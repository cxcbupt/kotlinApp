package com.example.cxc.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("CXC", "hello kotlin !")

        hello_tv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        log("CXC", "hello_tv clicked")

//        val txt = hello_tv.text;
        hello_tv.text = "_Hello_"

        var shape: Shape = Rectangle("rectangle", 2, 3)
        log(
            "CXC", "className=" + shape.javaClass.canonicalName
                    + ",shape:" + shape.shape
                    + ",perimeter=" + shape.getPerimeter()
        )

        shape = Triangle("triangle", 1, 2, 2)
        log(
            "CXC", "className=" + shape.javaClass.canonicalName
                    + ",shape:" + shape.shape
                    + ",perimeter=" + shape.getPerimeter()
        )
    }
}
