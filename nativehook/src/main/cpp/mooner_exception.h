//
// Created by pika on 2023/1/6.
//
#define HACKER_JNI_CLASS_NAME "com/bbc/NativeHacker"
#define HACKER_JNI_CLASS_EXCPTION_NAME "java/lang/Exception"
#define HACKER_JNI_CLASS_SYSTEM_NAME "java/lang/System"
#define HACKER_JNI_ERROR_HANDLER "onError"
#ifndef SIGNAL_SIGNAL_EXCEPTION_H
#define SIGNAL_SIGNAL_EXCEPTION_H
void handle_exception(JNIEnv *env);
#endif //SIGNAL_SIGNAL_EXCEPTION_H
