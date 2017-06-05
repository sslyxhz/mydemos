//
// Created by xh.zeng on 2017/6/5.
//

#include <jni.h>
#include <string>
#include <android/log.h>
#include "native-lib.h"


#ifdef __cplusplus
extern "C" {
#endif

/**
 * Class:     getName
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL
Java_com_xhz_mydemos_test_TestActivity_string2FromJNI(JNIEnv *env, jobject instance) {
    std::string hello = "Hello xhz, from C++ 2";
    return env->NewStringUTF(hello.c_str());
}

/**
 * Class:     getName
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL
Java_com_xhz_mydemos_test_TestActivity_stringFromJNI(JNIEnv *env, jobject instance) {
    std::string hello = "Hello xhz, from C++";
    __android_log_print(ANDROID_LOG_DEBUG,"native-lib","stringFromJNI");
    hello = "Hello xhz, from C++ 2";
    __android_log_print(ANDROID_LOG_DEBUG,"native-lib","stringFromJNI 2");
    hello = "Hello xhz, from C++ 3";
    __android_log_print(ANDROID_LOG_DEBUG,"native-lib","stringFromJNI 3");
    hello = "Hello xhz, from C++ 4";
    __android_log_print(ANDROID_LOG_DEBUG,"native-lib","stringFromJNI 4");
    hello = "Hello xhz, from C++ 5";
    __android_log_print(ANDROID_LOG_DEBUG,"native-lib","stringFromJNI 5");

    return env->NewStringUTF(hello.c_str());
}

#ifdef __cplusplus
}
#endif



