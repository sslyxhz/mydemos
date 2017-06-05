//
// Created by xh.zeng on 2017/6/5.
//

#include <jni.h>
#include <string>
#include "native-lib.h"

extern "C"
JNIEXPORT jstring JNICALL

Java_com_xhz_mydemos_test_TestActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
