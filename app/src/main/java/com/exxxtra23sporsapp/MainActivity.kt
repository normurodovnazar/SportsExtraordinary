package com.exxxtra23sporsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import com.exxxtra23sporsapp.databinding.WelcomeBinding
import kotlin.math.abs

class MainActivity : ComponentActivity() {

    private lateinit var welcome: WelcomeBinding
    private var y0 = Float.NaN
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        welcome = WelcomeBinding.inflate(layoutInflater)
        setContentView(welcome.root)
        welcome.pages.setOnClickListener {
            startActivity(Intent(this,Pages::class.java))
        }

        welcome.crossword.setOnClickListener {
            startActivity(Intent(this,Crossword::class.java))
        }

        welcome.button.setOnTouchListener { v, event ->
            if (y0.isNaN()) y0 = event.rawY
            v.y = event.rawY-80
            if (!y0.isNaN()) Log.e("e",abs(y0-v.y).toString())
            if (abs(y0-v.y)>150) {
                welcome.welcome.visibility = View.INVISIBLE
                welcome.home.visibility = View.VISIBLE
            }
            return@setOnTouchListener super.onTouchEvent(event)
        }
    }
}