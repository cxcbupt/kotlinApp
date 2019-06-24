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

        var txt = hello_tv.text
        log(TAG, "original text:$txt")

        txt = "${txt}_HELLO_"
        hello_tv.text = txt
        log(TAG, "new text:$txt")

        var shape: Shape? = Rectangle("rectangle", 2, 3)
        dumpMsg(shape)

        shape = null
        dumpMsg(shape)

        shape = Rectangle(2, 3)
        dumpMsg(shape)

        shape = Triangle(1, 2, 2)
        dumpMsg(shape)

        shape = Square(8)
        dumpMsg(shape)

//        testShapeAs(shape)
        /*log(
            TAG,
            "className=${shape.javaClass.canonicalName},shape:${testShape?.shape},width:${testShape?.length1}, perimeter = ${testShape?.getPerimeter()}"
        )*/

        /*test()

        val extensionFunc = "xxx".extensionFunc().also(::println)

        log(TAG, "-->extensionFunc:$extensionFunc")

        HelloJava.test()// kotlin call java*/
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

    }
}
