package com.exxxtra23sporsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AlphaAnimation
import android.widget.Button
import androidx.activity.ComponentActivity
import com.exxxtra23sporsapp.databinding.ActivityCrosswordBinding


class Crossword : ComponentActivity(), OnClickListener {

    private lateinit var bind: ActivityCrosswordBinding
    private lateinit var w1: List<Button>
    private lateinit var w2: List<Button>
    private lateinit var w3: List<Button>
    private lateinit var w4: List<Button>
    private lateinit var w5: List<Button>

    private var foundButtons = arrayListOf<Button>()
    private var foundWords = arrayListOf<List<Button>>()

    private var state = State.NOT_SELECTED
    private lateinit var selectedButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCrosswordBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initCrossword()
        clickListeners()
    }

    private fun clickListeners() {
        bind.finis.setOnClickListener {
            finish()
        }
        bind.quid.setOnClickListener {
            buttonClick(it as Button)
        }
        bind.underwater.setOnClickListener {
            buttonClick(it as Button)
        }
        bind.chee.setOnClickListener {
            buttonClick(it as Button)
        }
        bind.regball.setOnClickListener {
            buttonClick(it as Button)
        }
        bind.boaoshi.setOnClickListener {
            buttonClick(it as Button)
        }
        for (b in w1){
            b.setOnClickListener(this)
        }
        for (b in w2){
            b.setOnClickListener(this)
        }
        for (b in w3){
            b.setOnClickListener(this)
        }
        for (b in w4){
            b.setOnClickListener(this)
        }
        for (b in w5){
            b.setOnClickListener(this)
        }
    }

    private fun buttonClick(it: Button) {
        if (!foundButtons.contains(it))
        if (state==State.SELECTED){
            if (selectedButton== it){
                it.setBackgroundResource(R.drawable.rect_button_bg)
                state = State.NOT_SELECTED
                selectedButton = bind.no
            }else{
                makeAllButtonsDefault()
                it.setBackgroundResource(R.drawable.rect_black)
                state = State.SELECTED
                selectedButton = it
            }
        }else{
            it.setBackgroundResource(R.drawable.rect_black)
            state = State.SELECTED
            selectedButton = it
            animateAll()
        }
    }

    private fun makeAllButtonsDefault() {
        if (!foundButtons.contains(bind.quid)) bind.quid.setBackgroundResource(R.drawable.rect_button_bg)
        if (!foundButtons.contains(bind.underwater)) bind.underwater.setBackgroundResource(R.drawable.rect_button_bg)
        if (!foundButtons.contains(bind.chee)) bind.chee.setBackgroundResource(R.drawable.rect_button_bg)
        if (!foundButtons.contains(bind.regball)) bind.regball.setBackgroundResource(R.drawable.rect_button_bg)
        if (!foundButtons.contains(bind.boaoshi)) bind.boaoshi.setBackgroundResource(R.drawable.rect_button_bg)
    }

    private fun animateAll() {
        val an = AlphaAnimation(1f,.5f)
        an.duration = 400
        for (i in w1){
            i.startAnimation(an)
        }
        for (i in w2){
            i.startAnimation(an)
        }
        for (i in w3){
            i.startAnimation(an)
        }
        for (i in w4){
            i.startAnimation(an)
        }
        for (i in w5){
            i.startAnimation(an)
        }
    }

    private fun initCrossword() {
        w1 = listOf(
            bind.q1,
            bind.q2,
            bind.q3,
            bind.u3,
            bind.q4,
            bind.q5,
            bind.q6,
            bind.q7,
            bind.q8,
        )
        w2 = listOf(
            bind.u1,
            bind.u2,
            bind.u3,
            bind.u4,
            bind.u5,
            bind.u6,
            bind.u7,
            bind.u8,
            bind.u9,
            bind.u10,
        )
        w3 = listOf(
            bind.b1,
            bind.b2,
            bind.b3,
            bind.u7,
            bind.b5,
            bind.b6,
            bind.b7,
            bind.b8,
        )
        w4 = listOf(
            bind.c1,
            bind.c2,
            bind.u9,
            bind.c4,
            bind.c5,
            bind.c6,
        )
        w5 = listOf(
            bind.r1,
            bind.c6,
            bind.r3,
            bind.r4,
            bind.r5,
            bind.r6,
            bind.r7,
        )
    }

    override fun onClick(v: View?) {
        val tag = v?.tag.toString()
        Log.e("s",tag)
        if (state==State.SELECTED){
            clearIncorrectWords()
            if (tag.contains("w1")){
                if (!foundWords.contains(w1)) putWords(w1, w1.size==selectedButton.text.toString().replace("-","").length)
            }
            if (tag.contains("w2")){
                if (!foundWords.contains(w2)) putWords(w2, w2.size==selectedButton.text.toString().replace("-","").length)
            }
            if (tag.contains("w3")){
                if (!foundWords.contains(w3)) putWords(w3, w3.size==selectedButton.text.toString().replace("-","").length)
            }
            if (tag.contains("w4")){
                if (!foundWords.contains(w4)) putWords(w4, w4.size==selectedButton.text.toString().replace("-","").length)
            }
            if (tag.contains("w5")){
                if (!foundWords.contains(w5)) putWords(w5, w5.size==selectedButton.text.toString().replace("-","").length)
            }
        }
    }

    private fun putWords(w: List<Button>,correct: Boolean) {
        val text = selectedButton.text.toString().replace("-","")
        if (correct) {
            selectedButton.setBackgroundResource(R.drawable.yellow_rect)
            foundButtons.add(selectedButton)
            updateFoundWords(selectedButton)
        }
        for (i in w.indices){
            if (i<text.length) w[i].text = text[i].toString() else w[i].text = ""
            if (correct) w[i].setBackgroundResource(R.drawable.yellow_rect) else w[i].setBackgroundResource(R.drawable.rect_black)
        }
    }

    private fun clearIncorrectWords() {
        if (!foundWords.contains(w1)){
            for (i in w1){
                i.text = ""
                i.setBackgroundResource(R.drawable.white_rect)
            }
        }
        if (!foundWords.contains(w2)){
            for (i in w2){
                i.text = ""
                i.setBackgroundResource(R.drawable.white_rect)
            }
        }
        if (!foundWords.contains(w3)){
            for (i in w3){
                i.text = ""
                i.setBackgroundResource(R.drawable.white_rect)
            }
        }
        if (!foundWords.contains(w4)){
            for (i in w4){
                i.text = ""
                i.setBackgroundResource(R.drawable.white_rect)
            }
        }
        if (!foundWords.contains(w5)){
            for (i in w5){
                i.text = ""
                i.setBackgroundResource(R.drawable.white_rect)
            }
        }
    }

    private fun updateFoundWords(button: Button) {
        when(button){
            bind.quid -> {
                foundWords.add(w1)
            }
            bind.underwater -> {
                foundWords.add(w2)
            }
            bind.chee -> {
                foundWords.add(w4)
            }
            bind.regball -> {
                foundWords.add(w5)
            }
            bind.boaoshi -> {
                foundWords.add(w3)
            }
        }
    }
}