package com.exxxtra23sporsapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.exxxtra23sporsapp.databinding.PagesBinding

class Pages : ComponentActivity() {

    private lateinit var bind: PagesBinding
    private var current = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = PagesBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.next.setOnClickListener {
            if (current!=10) {
                current++
            }
            if (current!=1) {
                bind.back.isEnabled = true
                bind.back.alpha = 1f
            }
            if (current==10) {
                bind.next.isEnabled = false
                bind.next.alpha = .5f
            }
            setUI()
        }
        bind.back.setOnClickListener {
            if (current!=1){
                current--
            }
            if (current!=10) {
                bind.next.isEnabled = true
                bind.next.alpha = 1f
            }
            if (current==1) {
                bind.back.isEnabled = false
                bind.back.alpha = .5f
            }
            setUI()
        }

        bind.finis.setOnClickListener {
            finish()
        }
    }

    private fun setUI() {
        when(current){
            1 -> {
                makeAllInvisible()
                bind.p1.visibility = View.VISIBLE
                bind.b.text = "Quidditch 1/10"
            }
            2 -> {
                makeAllInvisible()
                bind.p2.visibility = View.VISIBLE
                bind.b.text = "Regball 2/10"
            }
            3 -> {
                makeAllInvisible()
                bind.p3.visibility = View.VISIBLE
                bind.b.text = "Soapbox Racing 3/10"
            }
            4 -> {
                makeAllInvisible()
                bind.p4.visibility = View.VISIBLE
                bind.b.text = "Cheese Rolling 4/10"
            }
            5 -> {
                makeAllInvisible()
                bind.p5.visibility = View.VISIBLE
                bind.b.text = "Underwater Hockey 5/10"
            }
            6 -> {
                makeAllInvisible()
                bind.p6.visibility = View.VISIBLE
                bind.b.text = "Canal Jumping 6/10"
            }
            7 -> {
                makeAllInvisible()
                bind.p7.visibility = View.VISIBLE
                bind.b.text = "Ear Pull 7/10"
            }
            8 -> {
                makeAllInvisible()
                bind.p8.visibility = View.VISIBLE
                bind.b.text = "Death Diving 8/10"
            }
            9 -> {
                makeAllInvisible()
                bind.p9.visibility = View.VISIBLE
                bind.b.text = "Bossaball 9/10"
            }
            10 -> {
                makeAllInvisible()
                bind.p10.visibility = View.VISIBLE
                bind.b.text = "Bo-taoshi 10/10"
            }
        }
    }

    private fun makeAllInvisible() {
        bind.p1.visibility = View.GONE
        bind.p2.visibility = View.GONE
        bind.p3.visibility = View.GONE
        bind.p4.visibility = View.GONE
        bind.p5.visibility = View.GONE
        bind.p6.visibility = View.GONE
        bind.p7.visibility = View.GONE
        bind.p8.visibility = View.GONE
        bind.p9.visibility = View.GONE
        bind.p10.visibility = View.GONE
    }
}