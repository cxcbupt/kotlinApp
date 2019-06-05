package com.example.cxc.kotlinapp

import android.util.Log

fun test() {
    val fruits = listOf("apple1", "banana1", "kiwifruit", "banana2", "avocado", "apple2", "kiwifruit")
    when {
        "orange" in fruits -> log("CXC", "juicy")
        "apple" in fruits -> log("CXC", "apple is fine too")
    }


    fruits.filter { it.isNotEmpty() && it.startsWith("a") }
        .sortedBy { it }
        .map { it + "_" + it.toUpperCase() }
        .forEach {
            log("CXC", it)
        }
}


fun log(tag: String, msg: String?) {
    Log.d(tag, msg)
}

//extension function
fun String.extensionFunc(): String {
    log("CXC", "-->space2CamelCase()")
    return "helloWorld"
}

abstract class Shape(shape: String) {
    var shape: String = shape

    abstract fun getPerimeter(): Int
}

class Rectangle(shape: String, width: Int, height: Int) : Shape(shape) {
    var width = width
    var height: Int = height

    override fun getPerimeter(): Int = 2 * (width + height)
}

class Triangle(shape: String, length1: Int, length2: Int, length3: Int) : Shape(shape) {
    var length1 = length1
    var length2 = length2
    var length3 = length3

    override fun getPerimeter(): Int = length1 + length2 + length3
}