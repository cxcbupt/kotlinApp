package com.example.cxc.kotlinapp;

public class HelloJava {
    public static void test() {
        //java call kotlin
        FooBarKt.test();
        FooBarKt.log(FooBarKt.TAG, "-->" + FooBarKt.TAG);
    }
}
