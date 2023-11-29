package com.exxxtra23sporsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.exxxtra23sporsapp.databinding.MainBinding

class MainActivity : ComponentActivity() {

    lateinit var bind: MainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = MainBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}