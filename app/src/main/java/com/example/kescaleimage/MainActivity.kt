package com.example.kescaleimage

import android.os.Bundle
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var myImage1: ImageView? = null
    var myImage2: ImageView? = null

    private var scaleGestureDetector1: ScaleGestureDetector? = null
    private var scaleGestureDetector2: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myImage1 = findViewById<View>(R.id.myimage1) as ImageView
        myImage2 = findViewById<View>(R.id.myimage2) as ImageView

        scaleGestureDetector1 = ScaleGestureDetector(
            this, MySimpleOnScaleGestureListener(myImage1!!)
        )
        scaleGestureDetector2 = ScaleGestureDetector(
            this, MySimpleOnScaleGestureListener(myImage2!!)
        )
        myImage1!!.setOnTouchListener { v, event ->
            scaleGestureDetector1!!.onTouchEvent(event)
            true
        }
        myImage2!!.setOnTouchListener { v, event ->
            scaleGestureDetector2!!.onTouchEvent(event)
            true
        }
    }

    private inner class MySimpleOnScaleGestureListener(var viewMyImage: ImageView) :
        SimpleOnScaleGestureListener() {
        var factor = 1.0f
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val scaleFactor = detector.scaleFactor - 1
            factor = factor + scaleFactor
            viewMyImage.scaleX = factor
            viewMyImage.scaleY = factor
            return true
            //return super.onScale(detector);
        }
    }
}