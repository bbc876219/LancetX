#include <android/log.h>
#include <dlfcn.h>
#include <fcntl.h>
#include <inttypes.h>
#include <jni.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
#include <unistd.h>
#include <setjmp.h>
#include <pthread.h>
#include "mooner_exception.h"
#include "bytehook.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeclaration-after-statement"
#define HACKER_JNI_VERSION    JNI_VERSION_1_6

#define HACKER_TAG            "hook_tag"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wgnu-zero-variadic-macro-arguments"
///** Verbose logging. Should typically be disabled for a release apk. */
//ANDROID_LOG_VERBOSE,
///** Debug logging. Should typically be disabled for a release apk. */
//ANDROID_LOG_DEBUG,
///** Informational logging. Should typically be disabled for a release apk. */
//ANDROID_LOG_INFO,
///** Warning logging. For use with recoverable failures. */
//ANDROID_LOG_WARN,
///** Error logging. For use with unrecoverable failures. */
//ANDROID_LOG_ERROR,
///** Fatal logging. For use when aborting. */
//ANDROID_LOG_FATAL,
#define LOGVT(tag, fmt, ...) __android_log_print(ANDROID_LOG_VERBOSE, tag, fmt, ##__VA_ARGS__)
#define LOGV(fmt, ...) __android_log_print(ANDROID_LOG_VERBOSE, HACKER_TAG, fmt, ##__VA_ARGS__)
#define LOGDT(tag, fmt, ...) __android_log_print(ANDROID_LOG_DEBUG, tag, fmt, ##__VA_ARGS__)
#define LOGD(fmt, ...) __android_log_print(ANDROID_LOG_DEBUG, HACKER_TAG, fmt, ##__VA_ARGS__)
#define LOGIT(tag, fmt, ...) __android_log_print(ANDROID_LOG_INFO, tag, fmt, ##__VA_ARGS__)
#define LOGI(fmt, ...) __android_log_print(ANDROID_LOG_INFO, HACKER_TAG, fmt, ##__VA_ARGS__)
#define LOGWT(tag, fmt, ...) __android_log_print(ANDROID_LOG_WARN, tag, fmt, ##__VA_ARGS__)
#define LOGW(fmt, ...) __android_log_print(ANDROID_LOG_WARN, HACKER_TAG, fmt, ##__VA_ARGS__)
#define LOGE(fmt, ...) __android_log_print(ANDROID_LOG_ERROR, HACKER_TAG, fmt, ##__VA_ARGS__)
#pragma clang diagnostic pop
static bool isHookOpen = false;
static bool isHookClose = false;
static bool isHookPTheadCreate = true;
static bool isHookPTheadRun = true;
static bool isHookPTheadSetName = true;
static bool isHookPTheadExit = false;
static bool isHookPTheadDetach = false;
static bool isHookPTheadJoin = false;
static bool isInterceptCrash = true;

// 原本线程参数
struct ThreadHookeeArgus {
    void *(*current_func)(void *);

    void *current_arg;
};

#define HACKER_JNI_HANDLER "onHandleSignal"
#define SIGNAL_CRASH_STACK_SIZE (1024 * 128)
static sigjmp_buf sig_env;
static volatile int handleFlag = 0;
static JNIEnv *currentEnv;
static struct sigaction old;

static void run(const struct ThreadHookeeArgus *temp);

extern JavaVM *currentVm;
extern jclass callClass;
JavaVM *currentVm = NULL;
jclass callClass = NULL;


static long long currentTimeInMilliseconds(void) {
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return ((tv.tv_sec * 1000) + (tv.tv_usec / 1000));
}


static void *pthread(void *arg) {
    JavaVMAttachArgs vmAttachArgs;
    jmethodID id;
    struct ThreadHookeeArgus *temp = (struct ThreadHookeeArgus *) arg;
    if (isInterceptCrash) {
        if (sigsetjmp(sig_env, 1)) {
            LOGE("crash 了，但被我抓住了");

            vmAttachArgs.version = HACKER_JNI_VERSION;
            vmAttachArgs.name = NULL;
            vmAttachArgs.group = NULL;
            __attribute__((unused)) jint attachRet = (*currentVm)->AttachCurrentThread(currentVm,
                                                                                       (JNIEnv **) &currentEnv,
                                                                                       &vmAttachArgs);
            // 现在处于native子线程，默认是booster加载器
            id = (*currentEnv)->GetStaticMethodID(currentEnv, callClass, HACKER_JNI_HANDLER, "()V");
            (*currentEnv)->CallStaticVoidMethod(currentEnv, callClass, id);
        } else {
            run(temp);
        }
    } else {
        run(temp);
    }
    handleFlag = 0;
    return NULL;
}

static void run(const struct ThreadHookeeArgus *temp) {
    if (isHookPTheadRun) {
        pthread_t th = pthread_self();
        int tid = pthread_gettid_np(th);
        long long start = currentTimeInMilliseconds();

        if (bytehook_get_debug())
            LOGWT("pthread.run", "thread start self()=%ld, tid:%d", th, tid);
        temp->current_func(temp->current_arg);
        long long end = currentTimeInMilliseconds();
        if (bytehook_get_debug())
            LOGWT("pthread.run", "thread end self()=%ld,tid:%d,cost: %lld", th, tid,(end - start));
    } else {
        temp->current_func(temp->current_arg);
    }
}

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"

static void sig_handler(int sig, struct siginfo *info, void *ptr) {

    if (handleFlag == 1) {
        siglongjmp(sig_env, 1);
    } else {
        // 交给原来的信号处理器处理
        sigaction(sig, &old, NULL);
    }
}

#pragma clang diagnostic pop

typedef int (*open_t)(const char *, int, mode_t);

typedef int (*open_real_t)(const char *, int, mode_t);

typedef int (*open2_t)(const char *, int);

typedef int (*close_t)(int);

typedef int (*pthread_create_t)(const pthread_t *, const pthread_attr_t *, void *(void *), void *);

typedef int (*pthread_detach_t)(pthread_t);

typedef void (*pthread_exit_t)(void *);

typedef int (*pthread_join_t)(pthread_t);

typedef int (*pthread_setname_np_t)(pthread_t, const char *);


#define OPEN_DEF(fn)                                                                                         \
  static fn##_t fn##_prev = NULL;                                                                            \
  static bytehook_stub_t fn##_stub = NULL;                                                                   \
  static void fn##_hooked_callback(bytehook_stub_t task_stub, int status_code, const char *caller_path_name, \
                                   const char *sym_name, void *new_func, void *prev_func, void *arg) {       \
    if (BYTEHOOK_STATUS_CODE_ORIG_ADDR == status_code) {                                                     \
      fn##_prev = (fn##_t)prev_func;                                                                         \
      if(bytehook_get_debug()) LOGV(">>>>> save original address: %" PRIxPTR, (uintptr_t)prev_func);                                   \
    } else {                                                                                                 \
      if(bytehook_get_debug()) LOGVT("hooked",">>>>> hooked. stub: %" PRIxPTR                                                                    \
          ", status: %d, caller_path_name: %s, sym_name: %s, new_func: %" PRIxPTR ", prev_func: %" PRIxPTR   \
          ", arg: %" PRIxPTR,                                                                                \
          (uintptr_t)task_stub, status_code, caller_path_name, sym_name, (uintptr_t)new_func,                \
          (uintptr_t)prev_func, (uintptr_t)arg);                                                             \
    }                                                                                                        \
  }
OPEN_DEF(open)

OPEN_DEF(open_real)

OPEN_DEF(open2)

OPEN_DEF(close)

OPEN_DEF(pthread_join)

OPEN_DEF(pthread_exit)

OPEN_DEF(pthread_detach)

OPEN_DEF(pthread_create)

OPEN_DEF(pthread_setname_np)

static bytehook_stub_t pthread_create_single_stub = NULL;

static void debug(const char *sym, const char *pathname, int flags, int fd, void *lr) {
    Dl_info info;
    memset(&info, 0, sizeof(info));
    dladdr(lr, &info);

    LOGIT(sym, "proxy %s(%d    \"%s\", %d), return FD: %d, called from: %s (%s)", sym, fd, pathname,
          flags, fd,
          info.dli_fname,
          info.dli_sname);
}

static void debug_close(const char *sym, int flags, int fd, void *lr) {
    Dl_info info;
    memset(&info, 0, sizeof(info));
    dladdr(lr, &info);

    LOGIT(sym, "proxy %s( %d), return RS: %d, called from: %s (%s)", sym, fd, flags, info.dli_fname,
          info.dli_sname);
}

static void
debug_thread_setname(const char *sym, int flags, pthread_t pt, const char *name, void *lr) {
    Dl_info info;
    memset(&info, 0, sizeof(info));
    dladdr(lr, &info);

    LOGI("proxy %s(%s), return RS: %d, pthread_t：%ld called from: %s (%s)", sym, name, flags,
         pt,
         info.dli_fname,
         info.dli_sname);
}

static void debug_thread(const char *sym, int flags, pthread_t pt, void *lr) {
    Dl_info info;
    memset(&info, 0, sizeof(info));
    dladdr(lr, &info);

    LOGDT(sym, "proxy %s(), return RS: %d, pthread_t：%ld called from: %s (%s)", sym, flags, pt,
          info.dli_fname,
          info.dli_sname);
}

static void debug_thread_create(const char *sym, int flags, pthread_t pt, void *lr) {
    Dl_info info;
    memset(&info, 0, sizeof(info));
    dladdr(lr, &info);

    LOGD("proxy %s(), return RS: %d, pthread_self()：%ld  called from: %s (%s)", sym,
         flags, pt,
         info.dli_fname,
         info.dli_sname);
}

static int open_proxy_auto(const char *pathname, int flags, mode_t modes) {
    // In automatic mode, if you need to call the original function,
    // please always use the BYTEHOOK_CALL_PREV() macro.
    int fd = BYTEHOOK_CALL_PREV(open_proxy_auto, open_t, pathname, flags, modes);
    if (bytehook_get_debug()) {
        debug("open", pathname, flags, fd, BYTEHOOK_RETURN_ADDRESS());
    }

    // Make sure to call BYTEHOOK_POP_STACK() macro before returning.
    // In the CPP source file, you can also call BYTEHOOK_STACK_SCOPE() macro
    // at the beginning of the proxy function instead.
    BYTEHOOK_POP_STACK();
    return fd;
}

static int open_real_proxy_auto(const char *pathname, int flags, mode_t modes) {
    int fd = BYTEHOOK_CALL_PREV(open_real_proxy_auto, open_real_t, pathname, flags, modes);
    if (bytehook_get_debug()) {
        debug("__open_real", pathname, flags, fd, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return fd;
}

static int open2_proxy_auto(const char *pathname, int flags) {
    int fd = BYTEHOOK_CALL_PREV(open2_proxy_auto, open2_t, pathname, flags);
    if (bytehook_get_debug()) {
        debug("__open_2", pathname, flags, fd, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return fd;
}

static int close_proxy_auto(int fd) {
    int rs = BYTEHOOK_CALL_PREV(close_proxy_auto, close_t, fd);
    if (bytehook_get_debug()) {
        debug_close("close", rs, fd, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return rs;
}

static int pthread_setname_np_proxy_auto(pthread_t pt, const char *name) {
    int rs = BYTEHOOK_CALL_PREV(pthread_setname_np_proxy_auto, pthread_setname_np_t, pt, name);
    if (bytehook_get_debug()) {
        debug_thread_setname("pthread_setname_np", rs, pt, name, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return rs;
}

static int pthread_join_proxy_auto(pthread_t pt) {
    int rs = BYTEHOOK_CALL_PREV(pthread_join_proxy_auto, pthread_join_t, pt);
    if (bytehook_get_debug()) {
        debug_thread("pthread_join", rs, pt, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return rs;
}

static int pthread_detach_proxy_auto(pthread_t pt) {
    int rs = BYTEHOOK_CALL_PREV(pthread_detach_proxy_auto, pthread_detach_t, pt);
    if (bytehook_get_debug()) {
        debug_thread("pthread_detach", rs, pt, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return rs;
}

static void pthread_exit_proxy_auto(void *return_value) {
    BYTEHOOK_CALL_PREV(pthread_exit_proxy_auto, pthread_exit_t, return_value);
    if (bytehook_get_debug()) {
        debug_thread("pthread_exit", 0, (pthread_t) NULL, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();
    return;
}

static int pthread_create_proxy_auto(pthread_t *thread, pthread_attr_t *attr,
                                     void *(*start_routine)(void *), void *arg) {
    struct ThreadHookeeArgus *params;
    params = (struct ThreadHookeeArgus *) malloc(sizeof(struct ThreadHookeeArgus));
    params->current_func = start_routine;
    params->current_arg = arg;

//  __android_log_print(ANDROID_LOG_INFO, HACKER_TAG, "%s", "call pthread_create");
//    int rs = BYTEHOOK_CALL_PREV(pthread_create_proxy_auto, pthread_create_t, thread, attr,
//                                start_routine, (void *) arg);
    int rs = BYTEHOOK_CALL_PREV(pthread_create_proxy_auto, pthread_create_t, thread, attr, pthread,
                                (void *) params);
    if (bytehook_get_debug()) {
        debug_thread_create("pthread_create", rs, (pthread_t) thread, BYTEHOOK_RETURN_ADDRESS());
    }
    BYTEHOOK_POP_STACK();

    return rs;
}
//static int pthread_create_proxy_auto_single(pthread_t *thread, pthread_attr_t *attr,
//                                     void *(*start_routine)(void *), void *arg) {
//    int rs =0;
//    struct ThreadHookeeArgus *params;
//    params = (struct ThreadHookeeArgus *) malloc(sizeof(struct ThreadHookeeArgus));
//    params->current_func = start_routine;
//    params->current_arg = arg;
//    handleFlag = 1;
//    //int rs = BYTEHOOK_CALL_PREV(pthread_create_proxy_auto_single, pthread_create_t, thread, attr,start_routine, (void *) arg);
//    rs = BYTEHOOK_CALL_PREV(pthread_create_proxy_auto_single,pthread_create_t, thread, attr,pthread,(void *) params);
//    if (bytehook_get_debug()) {
//        debug_thread_create("pthread_create", rs, (pthread_t) thread, BYTEHOOK_RETURN_ADDRESS());
//    }
//    BYTEHOOK_POP_STACK();
//
//    return rs;
//}




//static bool allow_filter(const char *caller_path_name, void *arg) {
//    (void) arg;
//
//    if (NULL != strstr(caller_path_name, "libc.so")) return false;
//    if (NULL != strstr(caller_path_name, "libbase.so")) return false;
//    if (NULL != strstr(caller_path_name, "liblog.so")) return false;
//    if (NULL != strstr(caller_path_name, "libunwindstack.so")) return false;
//    if (NULL != strstr(caller_path_name, "libutils.so")) return false;
//    // ......
//
//    return true;
//}

static bool allow_filter_for_hook_all(const char *caller_path_name, void *arg) {
    (void) arg;

    if (NULL != strstr(caller_path_name, "liblog.so")) return false;

    return true;
}

static int hacker_hook(JNIEnv *env, jobject thiz, jint type) {

    void *open_proxy;
    void *open_real_proxy;
    void *open2_proxy;
    void *close_proxy;
    void *pthread_join_proxy;
    void *pthread_detach_proxy;
    void *pthread_exit_proxy;
    void *pthread_create_proxy;
    void *pthread_setname_np_proxy;
//    void *pthread_create_single_proxy;
    struct sigaction sigc;
    (void) env, (void) thiz;
    currentEnv = env;
    if (bytehook_get_debug()) {
        LOGW("hacker_hook type=%d", type);
    }
//    if (type > 2 || type < 0) {
//        jclass clz = (*env)->FindClass(env, HACKER_JNI_CLASS_EXCPTION_NAME);
//        if (NULL == clz) {
//            jmethodID constructor_mid = (*env)->GetMethodID(env, clz, "<init>",
//                                                            "(Ljava/lang/String;)V");
//            jstring str = (*env)->NewStringUTF(env, "type is error");
//            jthrowable jthrowable = (*env)->NewObject(env, clz, constructor_mid, str);
//            (*env)->Throw(env, jthrowable);
//        } else {
//            //type =2；
//        }
//    }

    open_proxy = (void *) open_proxy_auto;
    open_real_proxy = (void *) open_real_proxy_auto;
    open2_proxy = (void *) open2_proxy_auto;
    close_proxy = (void *) close_proxy_auto;
    pthread_join_proxy = (void *) pthread_join_proxy_auto;
    pthread_detach_proxy = (void *) pthread_detach_proxy_auto;
    pthread_exit_proxy = (void *) pthread_exit_proxy_auto;
    pthread_create_proxy = (void *) pthread_create_proxy_auto;
    pthread_setname_np_proxy = (void *) pthread_setname_np_proxy_auto;
//    pthread_create_single_proxy = (void *) pthread_create_proxy_auto_single;


    if (isHookOpen) {
        open_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL, "open",
                                          open_proxy,
                                          open_hooked_callback, NULL);
        open_real_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                               "__open_real",
                                               open_real_proxy, open_real_hooked_callback,
                                               NULL);
        open2_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL, "__open_2",
                                           open2_proxy,
                                           open2_hooked_callback, NULL);
    }
    if (isHookClose) {
        close_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL, "close",
                                           close_proxy, close_hooked_callback, NULL);
    }
    if (isHookPTheadJoin)
        pthread_join_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                                  "pthread_join", pthread_join_proxy,
                                                  pthread_join_hooked_callback, NULL);
    if (isHookPTheadDetach)
        pthread_detach_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                                    "pthread_detach", pthread_detach_proxy,
                                                    pthread_detach_hooked_callback, NULL);
    if (isHookPTheadExit)
        pthread_exit_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                                  "pthread_exit", pthread_exit_proxy,
                                                  pthread_exit_hooked_callback, NULL);
    if (isHookPTheadCreate)
        pthread_create_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                                    "pthread_create", pthread_create_proxy,
                                                    pthread_create_hooked_callback, NULL);
    if (isHookPTheadSetName)
        pthread_setname_np_stub = bytehook_hook_partial(allow_filter_for_hook_all, NULL, NULL,
                                                        "pthread_setname_np",
                                                        pthread_setname_np_proxy,
                                                        pthread_setname_np_hooked_callback, NULL);

//        pthread_create_single_stub = bytehook_hook_single("libhookee.so", NULL, "pthread_create", pthread_create_single_proxy,
//                                          NULL, NULL);
//        pthread_create_single_stub = bytehook_hook_single("libhwui.so", NULL, "pthread_create", pthread_create_single_proxy,
//                                                          NULL, NULL);
    if (isInterceptCrash) {
        do {
            stack_t ss;
            if (NULL == (ss.ss_sp = calloc(1, SIGNAL_CRASH_STACK_SIZE))) {
                handle_exception(env);
                break;
            }
            ss.ss_size = SIGNAL_CRASH_STACK_SIZE;
            ss.ss_flags = 0;
            if (0 != sigaltstack(&ss, NULL)) {
                handle_exception(env);
                break;
            }

            sigc.sa_sigaction = sig_handler;
            sigemptyset(&sigc.sa_mask);
            // 推荐采用SA_RESTART 虽然不是所有系统调用都支持，被中断后重新启动，但是能覆盖大部分
            sigc.sa_flags = SA_SIGINFO | SA_ONSTACK | SA_RESTART;
            int flag = sigaction(11, &sigc, &old);
            if (flag == -1) {
                handle_exception(env);
                break;
            }
        } while (0);
    }


    return 0;
}


static int hacker_unhook(JNIEnv *env, jobject thiz) {
    (void) env, (void) thiz;

    if (NULL != open_stub) {
        bytehook_unhook(open_stub);
        open_stub = NULL;
    }
    if (NULL != open_real_stub) {
        bytehook_unhook(open_real_stub);
        open_real_stub = NULL;
    }
    if (NULL != open2_stub) {
        bytehook_unhook(open2_stub);
        open2_stub = NULL;
    }
    if (NULL != close_stub) {
        bytehook_unhook(close_stub);
        close_stub = NULL;
    }
    if (NULL != pthread_exit_stub) {
        bytehook_unhook(pthread_exit_stub);
        pthread_exit_stub = NULL;
    }
    if (NULL != pthread_join_stub) {
        bytehook_unhook(pthread_join_stub);
        pthread_join_stub = NULL;
    }
    if (NULL != pthread_detach_stub) {
        bytehook_unhook(pthread_detach_stub);
        pthread_detach_stub = NULL;
    }
    if (NULL != pthread_create_stub) {
        bytehook_unhook(pthread_create_stub);
        pthread_create_stub = NULL;
    }
    if (NULL != pthread_setname_np_stub) {
        bytehook_unhook(pthread_setname_np_stub);
        pthread_setname_np_stub = NULL;
    }
    if (NULL != pthread_create_single_stub) {
        bytehook_unhook(pthread_create_single_stub);
        pthread_create_single_stub = NULL;
    }


    return 0;
}

static void hacker_dump_records(JNIEnv *env, jobject thiz, jstring pathname) {
    (void) thiz;

    const char *c_pathname = (*env)->GetStringUTFChars(env, pathname, 0);
    if (NULL == c_pathname) return;

    int fd = open(c_pathname, O_CREAT | O_WRONLY | O_CLOEXEC | O_TRUNC | O_APPEND,
                  S_IRUSR | S_IWUSR);
    if (fd >= 0) {
        bytehook_dump_records(fd, BYTEHOOK_RECORD_ITEM_ALL);
        close(fd);
    }

    (*env)->ReleaseStringUTFChars(env, pathname, c_pathname);
}
/**
 * static bool isHookOpen = false;
static bool isHookClose = false;
static bool isHookPTheadCreate = true;
static bool isHookPTheadRun = true;
static bool isHookPTheadSetName = true;
static bool isHookPTheadExit = false;
static bool isHookPTheadDetach = false;
static bool isHookPTheadJoin = false;
static bool isInterceptCrash = true;
 */
static jboolean  hacker_set_hookswitch(JNIEnv *env, jobject thiz, jstring key, jboolean value) {
    (void)env, (void)thiz;
    bool rs=value;
    const char *c_key = (*env)->GetStringUTFChars(env, key, 0);
    if (NULL == c_key) return rs;

    LOGIT("HookSwitch","setHookSwitch = %s  value=%hhu",c_key,rs);

    if (strcasecmp(c_key, "isHookOpen") == 0){
        isHookOpen=value;

    }else if (strcasecmp(c_key, "isHookClose") == 0){
        isHookClose=value;
    }else if (strcasecmp(c_key, "isHookPTheadCreate") == 0){
        isHookPTheadCreate=value;
    }else if (strcasecmp(c_key, "isHookPTheadRun") == 0){
        isHookPTheadRun=value;
    }else if (strcasecmp(c_key, "isHookPTheadSetName") == 0){
        isHookPTheadSetName=value;
    }else if (strcasecmp(c_key, "isHookPTheadExit") == 0){
        isHookPTheadExit=value;
    }else if (strcasecmp(c_key, "isHookPTheadDetach") == 0){
        isHookPTheadDetach=value;
    }else if (strcasecmp(c_key, "isHookPTheadJoin") == 0){
        isHookPTheadJoin=value;
    }else if (strcasecmp(c_key, "isInterceptCrash") == 0){
        isInterceptCrash=value;
    }

    return  value;
}
static bool setApiBlacklistExemptions(JNIEnv *env) {
    LOGE("setApiBlacklistExemptions start");
    /*=================在这里使用了ZygoteInit,而不是VMRuntime, 效果一样==================*/
    jclass zygoteInitClass = (*env)->FindClass(env,"com/android/internal/os/ZygoteInit");
    if (zygoteInitClass == NULL) {
        LOGE("not found class");
        (*env)->ExceptionClear(env);
        return false;
    }

    jmethodID setApiBlackListApiMethod =
            (*env)->GetStaticMethodID(env,zygoteInitClass,
                                   "setApiBlacklistExemptions",
                                   "([Ljava/lang/String;)V");
    if (setApiBlackListApiMethod == NULL) {
        (*env)->ExceptionClear(env);
        setApiBlackListApiMethod =
                (*env)->GetStaticMethodID(env,zygoteInitClass,
                                       "setApiDenylistExemptions",
                                       "([Ljava/lang/String;)V");
    }

    if (setApiBlackListApiMethod == NULL) {
        LOGE("not found method");
        return false;
    }

    jclass stringCLass = (*env)->FindClass(env,"java/lang/String");

    jstring fakeStr = (*env)->NewStringUTF(env,"L");

    jobjectArray fakeArray = (*env)->NewObjectArray(env,
            1, stringCLass, NULL);

    (*env)->SetObjectArrayElement(env,fakeArray, 0, fakeStr);

    (*env)->CallStaticVoidMethod(env,zygoteInitClass,setApiBlackListApiMethod, fakeArray);

    (*env)->DeleteLocalRef(env,fakeStr);
    (*env)->DeleteLocalRef(env,fakeArray);
    LOGE("fakeapi success!");
    return true;
}
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    (void) reserved;

    if (NULL == vm) return JNI_ERR;

    JNIEnv *env;
    currentVm = vm;

    if (JNI_OK != (*vm)->GetEnv(vm, (void **) &env, HACKER_JNI_VERSION)) return JNI_ERR;
    if (NULL == env || NULL == *env) return JNI_ERR;
    if (!setApiBlacklistExemptions(env)) {
        LOGE("setApiBlacklistExemptions failed");
    }
    jclass cls;
    if (NULL == (cls = (*env)->FindClass(env, HACKER_JNI_CLASS_NAME))) return JNI_ERR;

    JNINativeMethod m[] = {{"nativeHook",        "(I)I",                  (void *) hacker_hook},
                           {"nativeUnhook",      "()I",                   (void *) hacker_unhook},
                           {"nativeDumpRecords", "(Ljava/lang/String;)V", (void *) hacker_dump_records},
                           {"setHookSwitch", "(Ljava/lang/String;Z)V",(void *)hacker_set_hookswitch}
                           };
    if (0 != (*env)->RegisterNatives(env, cls, m, sizeof(m) / sizeof(m[0]))) return JNI_ERR;

// 此时的cls仅仅是一个局部变量，如果错误引用会出现错误
    callClass = (*env)->NewGlobalRef(env, cls);

    return HACKER_JNI_VERSION;
}




