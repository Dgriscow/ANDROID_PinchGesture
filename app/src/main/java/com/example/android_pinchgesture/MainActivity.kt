package com.example.android_pinchgesture

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.widget.ImageView
import android.view.MotionEvent

lateinit var iv:ImageView

var scale = 1f

class MainActivity : AppCompatActivity() {
    var ourSD: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv = findViewById(R.id.imageView)
        ourSD = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        ourSD?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}


class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){



    override fun onScale(detector: ScaleGestureDetector):Boolean {
        scale *= detector.scaleFactor
        scale = Math.max(0.1F, Math.min(scale, 5.0f))

        iv.scaleX = scale
        iv.scaleY = scale

        return true
    }


}