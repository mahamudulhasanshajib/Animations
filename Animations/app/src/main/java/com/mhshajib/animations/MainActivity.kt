package com.mhshajib.animations

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var rotateButton:Button
    private lateinit var moveButton: Button
    private lateinit var firstAlertImage:ImageView
    private lateinit var headingText:TextView
    private lateinit var secondAlertImage:ImageView
    private lateinit var vibrateButton: Button


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveButton=findViewById(R.id.moveButton)
        headingText=findViewById(R.id.heading)
        rotateButton=findViewById(R.id.rotate)
        secondAlertImage=findViewById(R.id.alart2)
        firstAlertImage=findViewById(R.id.alart1)
        vibrateButton=findViewById(R.id.vibrate)

        val animation=AnimationUtils.loadAnimation(this,R.anim.rotate)
        headingText.startAnimation(animation)
        rotateButton.setOnClickListener {
           val  animation=AnimationUtils.loadAnimation(this,R.anim.rotate)
            firstAlertImage.startAnimation(animation)
            secondAlertImage.startAnimation(animation)
        }
        moveButton.setOnClickListener {
            val  animation=AnimationUtils.loadAnimation(this,R.anim.zoom)
            firstAlertImage.startAnimation(animation)
            secondAlertImage.startAnimation(animation)
        }
        vibrateButton.setOnClickListener {
            val animator1 = ObjectAnimator.ofFloat(firstAlertImage, View.TRANSLATION_X, 20f)
            val animator2 =ObjectAnimator.ofFloat(secondAlertImage,View.TRANSLATION_Y,20f)
            animator1.repeatCount = 5
            animator2.repeatCount= 10
            animator1.repeatMode = ObjectAnimator.REVERSE
            animator1.duration=100
            animator2.repeatMode = ObjectAnimator.RESTART
            animator2.duration=50
            animator1.start()
            animator2.start()
        }



    }
}