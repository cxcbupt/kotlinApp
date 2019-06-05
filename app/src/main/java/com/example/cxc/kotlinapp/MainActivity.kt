package com.example.cxc.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log(TAG, "hello kotlin !")

        hello_tv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        log(TAG, "hello_tv clicked")

        var txt = hello_tv.text
        log("CXC", "original text:$txt")

        txt = "${txt}_HELLO_"
        hello_tv.text = txt
        log(TAG, "new text:$txt")

        var shape: Shape? = Rectangle("rectangle", 2, 3)
        log(TAG, "shape#perimeter:" + shape?.getPerimeter())
        shape = null
//        log(TAG, "shape#perimeter:" + (shape?.getPerimeter() ?: "null value"))
        val perimeter = shape?.getPerimeter() ?: -1
        log(TAG, "shape#perimeter:$perimeter")


        shape = Rectangle("rectangle", 2, 3)
        log(
            TAG, "className=" + shape.javaClass.canonicalName
                    + ",shape:" + shape.shape
                    + ",perimeter=" + shape.getPerimeter()
        )
        log(TAG, "shape is Triangle:" + (shape is Rectangle))

        shape = Triangle("triangle", 1, 2, 2)
        log(
            TAG, "className=" + shape.javaClass.canonicalName
                    + ",shape:" + shape.shape
                    + ",perimeter=" + shape.getPerimeter()
        )

        log(TAG, "shape is Triangle:" + (shape is Triangle))

        when (shape) {
            is Rectangle -> log(TAG, "-->width:" + shape.width + ",height:" + shape.height)
            is Triangle -> log(
                TAG,
                "-->length1:" + shape.length1 + ",length2:" + shape.length2 + ",length3:" + shape.length3
            )
            else -> {
                log(TAG, "-->wrong shape type")
            }
        }


        test()

        val extensionFunc = "xxx".extensionFunc().also(::println)

        log(TAG, "-->extensionFunc:$extensionFunc")
    }
}
