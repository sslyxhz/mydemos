//
// Created by xh.zeng on 2017/6/5.
//
#include <jni.h>
#include <string>
#include <android/log.h>

extern "C"
JNIEXPORT jint JNICALL
Java_com_xhz_mydemos_test_TestActivity_stringHelloJni(JNIEnv *env, jobject instance) {
    std::string hello = "Hello jni..";
    jclass clazz = env->FindClass("com/xhz/mydemos/test/TestActivity");
    jmethodID jmethodid = env->GetMethodID(clazz,"add","(II)I");
    jobject jobject1 = env->AllocObject(clazz);

    //__android_log_print(ANDROID_LOG_DEBUG,"hellojni","stringHelloJni");
    return env->CallIntMethod(jobject1, jmethodid, 3, 5);
}

