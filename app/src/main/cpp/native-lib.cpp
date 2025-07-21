#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_plus(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    return a + b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_minus(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    return a - b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_multiply(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    return a * b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_ru_evgenykuzakov_infotecs_1tt_12_NativeCalc_division(
        JNIEnv *env,
        jobject thiz,
        jdouble a,
        jdouble b) {
    return a / b;
}