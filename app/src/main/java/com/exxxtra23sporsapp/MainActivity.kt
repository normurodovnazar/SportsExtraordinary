package com.exxxtra23sporsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.ComponentActivity
import com.exxxtra23sporsapp.databinding.WelcomeBinding

class MainActivity : ComponentActivity() {

    private lateinit var welcome: WelcomeBinding
    private lateinit var music : MediaPlayer
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        welcome = WelcomeBinding.inflate(layoutInflater)
        setContentView(welcome.root)
        music = MediaPlayer.create(this,R.raw.m)
        music.isLooping = true
        welcome.pages.setOnClickListener {
            startActivity(Intent(this,Pages::class.java))
        }
        welcome.crossword.setOnClickListener {
            startActivity(Intent(this,Crossword::class.java))
        }
        welcome.seek.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.e("e",progress.toString())
                if (progress>50) welcome.seek.progress = 50
                if (progress<=20) {
                    welcome.welcome.visibility = View.INVISIBLE
                    welcome.home.visibility = View.VISIBLE
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                welcome.seek.progress = 50
            }

        })
        welcome.music.setOnClickListener {
            if (music.isPlaying){
                it.alpha = 0.5f
                music.pause()
            } else {
                it.alpha = 1f
                music.start()
            }
        }
        music.start()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Log.e("e","sdg")
            music.stop()
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        music.stop()
    }
}