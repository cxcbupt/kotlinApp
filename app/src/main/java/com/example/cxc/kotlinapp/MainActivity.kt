package com.example.cxc.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log(TAG, "hello kotlin !")

        hello_tv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        log(TAG, "hello_tv clicked")

        var txt = hello_tv.text
        log(TAG, "original text:$txt")

        txt = "${txt}_HELLO_"
        hello_tv.text = txt
        log(TAG, "new text:$txt")

        var shape: Shape? = Rectangle("rectangle", 2, 3)
        log(
            TAG, "shape:${shape?.shape}, perimeter = ${shape?.getPerimeter()}"
        )

        shape = null
        log(
            TAG, "shape:${shape?.shape}, perimeter = ${shape?.getPerimeter()}"
        )

        shape = Rectangle(2, 3)
        log(
            TAG, "className=${shape.javaClass.canonicalName},shape:${shape.shape}, perimeter = ${shape.getPerimeter()}"
        )

        shape = Triangle(1, 2, 2)
        log(
            TAG, "className=${shape.javaClass.canonicalName},shape:${shape.shape}, perimeter = ${shape.getPerimeter()}"
        )

        shape = Square(8)
        log(
            TAG, "className=${shape.javaClass.canonicalName},shape:${shape.shape}, perimeter = ${shape.getPerimeter()}"
        )

        when (shape) {
            is Rectangle -> log(TAG, "-->width:${shape.width},height:${shape.height}")
            is Triangle -> log(
                TAG,
                "-->length1:${shape.length1},length2:${shape.length2},length3:${shape.length3}"
            )
            is Square -> log(TAG, "-->width:${shape.width},height:${shape.height}")
            else -> {
                log(TAG, "-->wrong shape type")
            }
        }

        testShape(shape)
        /*log(
            TAG,
            "className=${shape.javaClass.canonicalName},shape:${testShape?.shape},width:${testShape?.length1}, perimeter = ${testShape?.getPerimeter()}"
        )*/

        /*test()

        val extensionFunc = "xxx".extensionFunc().also(::println)

        log(TAG, "-->extensionFunc:$extensionFunc")

        HelloJava.test()// kotlin call java*/
    }


    private fun testShape(shape: Shape) {
        val triangle = shape as?Triangle
        log(
            TAG,
            "-->length1:${triangle?.length1},length2:${triangle?.length2},length3:${triangle?.length3}"
        )

        if (shape is Triangle) {
            log(
                TAG,
                "-->length1:${shape.length1},length2:${shape.length2},length3:${shape.length3}"
            )
        }
    }
}
