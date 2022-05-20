package com.example.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.memorygame.R.drawable.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btn10: Button = findViewById(R.id.btn10)
        val btn11: Button = findViewById(R.id.btn11)
        val btn12: Button = findViewById(R.id.btn12)

        val numbers: MutableList<Int> = mutableListOf(
            one, two, three,
            four, five, six,

            one, two, three,
            four, five, six)

        val button = arrayOf(
            btn1,btn2,btn3,
            btn4, btn5, btn6,
            btn7, btn8, btn9,
            btn10, btn11, btn12)

        var click = 0
        var turn = false
        var lastClick = -1
        numbers.shuffle()
        for (i in 0..11){
            //to set the card back
            button[i].text = "cardback"
            button[i].textSize = 0.0F
            button[i].setOnClickListener {
                if (button[i].text == "cardback" && !turn) {
                    button[i].setBackgroundResource(numbers[i])
                    button[i].setText(numbers[i])
                    if (click == 0) {
                        lastClick = i
                    }
                    click++
                } else if (button[i].text != "cardback"){
                    button[i].setBackgroundColor(Color.rgb(120, 147, 138))
                    button[i].text = "cardback"
                    click--
                }

                if (click == 2) {
                    turn = true
                    if (button[i].text == button[lastClick].text) {
                        button[i].isClickable = false
                        button[lastClick].isClickable = false
                        turn = false
                        click = 0
                    }
                } else if (click == 0) {
                    turn = false
                }
            }
        }
    }
}