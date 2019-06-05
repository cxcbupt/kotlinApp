package com.example.cxc.kotlinapp

import android.util.Log


fun log(tag: String, msg: String) {
    Log.d(tag, msg)
}

abstract class Shape(shape: String) {
    var shape: String = ""

    init {
        this.shape = shape
    }

    abstract fun getPerimeter(): Int
}

class Rectangle(shape: String, width: Int, height: Int) : Shape(shape) {
    private var width = 0
    private var height: Int = 0

    init {
        this.width = width
        this.height = height
    }

    override fun getPerimeter(): Int = 2 * (width + height)
}

class Triangle(shape: String, length1: Int, length2: Int, length3: Int) : Shape(shape) {
    private var length1: Int = 0
    private var length2: Int = 0
    private var length3: Int = 0

    init {
        this.length1 = length1
        this.length2 = length2
        this.length3 = length3
    }

    override fun getPerimeter(): Int = length1 + length2 + length3
}