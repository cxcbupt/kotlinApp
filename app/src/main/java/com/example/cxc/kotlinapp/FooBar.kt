package com.example.cxc.kotlinapp

import android.util.Log

const val TAG = "FooBar"

fun test() {
    val fruits = listOf("apple1", "banana1", "kiwifruit", "banana2", "avocado", "apple2", "kiwifruit")
    when {
        "orange" in fruits -> log(TAG, "juicy")
        "apple" in fruits -> log(TAG, "apple is fine too")
    }


    fruits.filter { it.isNotEmpty() && it.startsWith("a") }
        .sortedBy { it }
        .map { it + "_" + it.toUpperCase() }
        .forEach {
            log(TAG, it)
        }
}


fun log(tag: String, msg: String?) {
    Log.d(tag, msg)
}

//extension function
fun String.extensionFunc(): String {
    log(TAG, "-->space2CamelCase()")
    return "helloWorld"
}

abstract class Shape(var shape: String) {

    abstract fun getPerimeter(): Int
}

class Rectangle(shape: String, var width: Int, var height: Int) : Shape(shape) {
    constructor(width: Int, height: Int) : this("Rectangle", width, height)

    override fun getPerimeter(): Int = 2 * (width + height)
}

class Triangle constructor(shape: String, var length1: Int, var length2: Int, var length3: Int) : Shape(shape) {

    constructor(length1: Int, length2: Int, length3: Int) : this("Triangle", length1, length2, length3)

    override fun getPerimeter(): Int = length1 + length2 + length3
}