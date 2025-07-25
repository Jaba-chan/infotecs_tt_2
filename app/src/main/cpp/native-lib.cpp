#include <jni.h>
#include <string>
#include <android/log.h>

#define LOG_TAG "NativeCalc"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG,  __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_plus(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    LOGI("Addition: %f + %f", a, b);
    return a + b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_minus(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    LOGI("Subtraction: %f - %f", a, b);
    return a - b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_multiply(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    LOGI("Multiplication: %f * %f", a, b);
    return a * b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_division(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    if (b == 0.0){
        LOGE("Division by zero: %f / %f", a, b);
        env->ThrowNew(env->FindClass("java/lang/ArithmeticException"), "Division by zero");
        return -1;
    }
    LOGI("Division: %f / %f", a, b);
    return a / b;
}