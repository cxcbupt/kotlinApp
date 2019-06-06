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

fun log(msg: String?) {
    log(TAG, msg)
}

//extension function
fun String.extensionFunc(): String {
    log(TAG, "-->space2CamelCase()")
    return "helloWorld"
}

abstract class Shape(val shape: String = "") {

    abstract fun getPerimeter(): Int
}

open class Rectangle(shape: String, var width: Int = 0, var height: Int = 0) : Shape(shape) {
    constructor(width: Int, height: Int) : this("Rectangle", width, height)

    override fun getPerimeter(): Int = 2 * (width + height)
}

class Triangle constructor(shape: String, var length1: Int = 0, var length2: Int = 0, var length3: Int = 0) :
    Shape(shape) {

    constructor(length1: Int, length2: Int, length3: Int) : this("Triangle", length1, length2, length3)

    override fun getPerimeter(): Int = length1 + length2 + length3
}

class Square(shape: String, size: Int = 0) : Rectangle(shape, size, size) {
    constructor(size: Int) : this("Square", size)
}

open class Base {
    constructor() {
        log(TAG, "-->BaseShape constructor()")
    }

    constructor(name: String) : this() {
        log(TAG, "-->BaseShape constructor($name)")
    }
}

class Custom : Base {

    constructor(name: String) : super(name) {
        log(TAG, "-->CustomShape constructor($name)")
    }

    constructor(name: String, age: Int) : this(name) {
        log(TAG, "-->CustomShape constructor($name,$age)")
    }
}