package com.example.cxc.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log(TAG, "hello kotlin !")

        hello_tv.setOnClickListener { onClick() }
    }

    private fun onClick() {
        log(TAG, "hello_tv clicked")

        log(TAG, "original text:${hello_tv.text}")

        hello_tv.text = "${hello_tv.text}_hello_"
        log(TAG, "new text:${hello_tv.text}")

        /* var shape: Shape? = Rectangle("rectangle", 2, 3)
         dumpMsg(shape)

         shape = null
         dumpMsg(shape)

         shape = Rectangle(2, 3)
         dumpMsg(shape)

         shape = Triangle(1, 2, 2)
         dumpMsg(shape)

         shape = Square(8)
         dumpMsg(shape)*/

//        testString()

//        testShapeAs(shape)

        /*test()

        val extensionFunc = "xxx".extensionFunc().also(::println)

        log(TAG, "-->extensionFunc:$extensionFunc")

        HelloJava.test()// kotlin call java*/

        testArray()
    }


    private fun testShapeAs(shape: Shape) {
        log(TAG, "-->testShapeAs()--")
        dumpMsg(shape)
        if (shape is Triangle) dumpMsg(shape)

        val triangle = shape as?Triangle
        dumpMsg(triangle)
    }

    private fun dumpMsg(shape: Shape?) {
        log(TAG, "-->dumpMsg()--class:${shape?.javaClass?.canonicalName}")
        when (shape) {
            is Triangle -> log(
                TAG,
                "length1:${shape.length1},length2:${shape.length2},length3:${shape.length3}"
            )
            is Square -> log(TAG, "-->size:${shape.width}")
            is Rectangle -> log(TAG, "-->width:${shape.width},height:${shape.height}")
            else -> {
                log(TAG, "-->unknown shape type")
            }
        }
    }

    private fun testString() {
        var str = "fkjava.org"

        for (c in str) {
            println(c)
        }

        var str2 = """
            |测试001
            |测试002
            |测试003
            |测试004
        """.trimMargin()
        println(str2)


        val s1 = "2.34"
        println(s1.toIntOrNull())
    }

    private fun testArray() {
        var strArray = arrayOf("java", "C++", "C#", "Android")
        println(strArray.contentToString())

        var intArray = Array(10) { it * it }

        //for-in
        for (it in intArray) println(it)

        //indices
        for (index in intArray.indices) println("[$index]:${intArray[index]}")

        //withIndex
        for ((index, value) in intArray.withIndex()) println("[$index]:$value")

        //util
        for (index in 0 until intArray.size) println("[$index]:${intArray[index]}")
        for (index in 0..intArray.lastIndex) println("[$index]:${intArray[index]}")

        //for in with step
        for (index in 0 until intArray.size step 2) println("[$index]:${intArray[index]}")

        //all
        println("all <100?${intArray.all { it < 100 }}")
        println("all > 50?${intArray.all { it > 50 }}")

        //any
        println("any >100?${intArray.any { it > 100 }}")
        println("any <50?${intArray.any { it < 100 }}")

        //asList
        println("asList:${intArray.asList()}")

        //contentToString
        println("contentToString${intArray.contentToString()}")

        //count
        println(">50 count:${intArray.count { it > 50 }}")

        //average
        println("average:${intArray.average()}")

        //drop
        println("drop(3):${intArray.drop(3)}")
        println("content to String:${intArray.contentToString()}")

        println("dropLast(3):${intArray.dropLast(3)}")
        println("content to String:${intArray.contentToString()}")

        //drop while
        println("dropWhile <50:${intArray.dropWhile { it < 50 }}")
        println("dropLastWhile >50:${intArray.dropLastWhile { it > 50 }}")
    }
}
