#include <android/log.h>
#include <fcntl.h>
#include <jni.h>
#include <stdlib.h>
#include <unistd.h>
#include "threads.h"

#define HOOKEE_JNI_VERSION    JNI_VERSION_1_6
#define HOOKEE_JNI_CLASS_NAME "com/bbc/NativeHookee"
#define HOOKEE_TAG            "native_test"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wgnu-zero-variadic-macro-arguments"
#define LOG(fmt, ...) __android_log_print(ANDROID_LOG_INFO, HOOKEE_TAG, fmt, ##__VA_ARGS__)

#pragma clang diagnostic pop

#pragma clang optimize off

static void *pthreadtest(void *rs) {

    __android_log_print(ANDROID_LOG_INFO, "mooner", "%s", "pthreadtest start");
    sleep(1);
    raise(SIGSEGV);
    __android_log_print(ANDROID_LOG_INFO, "mooner", "%s", "pthreadtest end");
    return rs;
}

static void create_thread_crash(JNIEnv *env, jobject thiz) {
    pthread_t tidp;
    (void) env, (void) thiz;

    if (pthread_create(&tidp, NULL, pthreadtest, NULL)) {
        __android_log_print(ANDROID_LOG_INFO, "mooner", "%s", "pthread_create fail");
    }
}

static void thread_1(void) {

    int i = 0;
    LOG("我是线程一 开始");
    while (1) {
        i += 1;
        sleep(1);
        LOG("我是线程一 %d次\n", i);
        if (i > 5) {
            break;
        }
    }
    LOG("我是线程一 结束");


}




#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wmissing-noreturn"
static void thread_2(void) {

    int i = 0;


//    pthread_t th=pthread_self();


    //LOG("我是线程二 开始   pthread_self()=%ld, tid:%d", th, pthread_gettid_np(th));
    while (1) {
        i += 1;
        sleep(2);
        LOG("我是线程二 %d次\n", i);
        if (i > 5) {
            break;
        }
    }
    LOG("我是线程二 结束");
    pthread_exit(NULL);
}
#pragma clang diagnostic pop


static void thread_3(void) {

    int i = 0;
    LOG("我是线程三 开始");
    while (3) {
        i += 1;
        sleep(3);
        LOG("我是线程三 %d次\n", i);
        if (i > 5) {
            break;
        }
    }
    LOG("我是线程三 结束");

}

static void hookee_test(JNIEnv *env, jobject thiz) {
    mode_t f_attrib;
    int fd, fd1;
    //线程开始的地址
    pthread_t star_location_1, star_location_2, star_location_3;
    int ret;
    (void) env, (void) thiz;
    LOG("source libhookee.so test open() start ");
    f_attrib = S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH; // 声明mode_t
    fd = open("/dev/null", O_RDWR);
    if (fd >= 0) close(fd);
    fd1 = open64("/dev/null", O_RDWR, f_attrib);
    if (fd1 >= 0) close(fd1);

    LOG("source libhookee.so test open() end ");

    //创建线程
    ret = pthread_create(&star_location_1, NULL, (void *(*)(void *)) thread_1, NULL);
    if (ret != 0) {
        LOG("star_location_1 pthread_create fail ");
    }

    ret = pthread_create(&star_location_2, NULL, (void *(*)(void *)) thread_2, NULL);
    if (ret != 0) {
        LOG("star_location_2 pthread_create fail ");
    }

    ret = pthread_create(&star_location_3, NULL, (void *(*)(void *)) thread_3, NULL);
    if (ret != 0) {
        LOG("star_location_3 pthread_create fail ");
    }

//设置线程为分离属性
    ret = pthread_detach(star_location_1);
    if (ret != 0) {
        LOG("pthread_detach fail");
    }
    pthread_setname_np(star_location_1, "thread_line_1");
    pthread_setname_np(star_location_2, "thread_line_2");
    pthread_setname_np(star_location_3, "thread_line_3");
    //子线程设置分离属性,则pthread_join不再阻塞,立刻返回
    /*等待线程结束*/
    ret = pthread_join(star_location_1, NULL);
    if (ret != 0) {
        LOG("pthread_join star_location_1 fail");
    }
    ret = pthread_join(star_location_2, NULL);
    if (ret != 0) {
        LOG("pthread_join star_location_2 fail");
    }
    ret = pthread_join(star_location_3, NULL);
    if (ret != 0) {
        LOG("pthread_join star_location_3 fail");
    }
    sleep(3);
    LOG("主线程退出");


}

#pragma clang optimize on

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    (void) reserved;

    if (NULL == vm) return JNI_ERR;


    if (JNI_OK != (*vm)->GetEnv(vm, (void **) &env, HOOKEE_JNI_VERSION)) return JNI_ERR;
    if (NULL == env || NULL == *env) return JNI_ERR;

    jclass cls;
    if (NULL == (cls = (*env)->FindClass(env, HOOKEE_JNI_CLASS_NAME))) return JNI_ERR;

    JNINativeMethod m[] = {{"nativeTest",               "()V", (void *) hookee_test},
                           {"createNativeThreadCreate", "()V", (void *) create_thread_crash}};
    if (0 != (*env)->RegisterNatives(env, cls, m, sizeof(m) / sizeof(m[0]))) return JNI_ERR;

    return HOOKEE_JNI_VERSION;
}

