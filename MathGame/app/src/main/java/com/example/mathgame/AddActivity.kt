package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random
import android.os.CountDownTimer as CountDownTimer1

class AddActivity : AppCompatActivity() {
    lateinit var buttonOk: Button
    lateinit var buttonNext:Button
    lateinit var textQuestion: TextView
    lateinit var editAnswer: EditText
    lateinit var textScore: TextView
    lateinit var textLife: TextView
    lateinit var textTime: TextView

    lateinit var timer: CountDownTimer1
    private val startTimerInMillis:Long=20000
    var timeLeftInMillis=startTimerInMillis


    var actualAnswer=0
    var score=0
    var life=3
    var status=true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        buttonNext=findViewById(R.id.buttonNext)
        buttonOk=findViewById(R.id.buttonOk)
        textLife=findViewById(R.id.textViewLife)
        textTime=findViewById(R.id.textViewTime)
        textScore=findViewById(R.id.textViewScore)
        editAnswer=findViewById(R.id.editTextAnswer)
        textQuestion=findViewById(R.id.TextViewQuestion)
        gameContinue()

        buttonOk.setOnClickListener {
            val input=editAnswer.text.toString()
            if(input==""){
                Toast.makeText(applicationContext, "Please write an answer or Click Next", Toast.LENGTH_SHORT).show()

            }
            else if (status==false){
                Toast.makeText(applicationContext, "Please Click Next", Toast.LENGTH_SHORT).show()

            }
            else{
                pauseTimer()
                val userAnswer=input.toInt()
                if(userAnswer==actualAnswer){
                    score+=10
                    textQuestion.text="You answered correctly!!"
                    textScore.text=score.toString()
                    status=false


                }
                else{
                    textQuestion.text="Oops.. Wrong answer"
                    life--;
                    textLife.text=life.toString()
                    status=false
                    if(life==0){

                    }

                }

            }
        }
        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()

            status=true
            gameContinue()
            editAnswer.setText("")

        }

    }
    fun gameContinue(){
        var num1=Random.nextInt(0,100)
        var num2=Random.nextInt(0,100)
        textQuestion.text="$num1 + $num2"
        actualAnswer=num1+num2
        startTimer()
    }
    fun startTimer(){
        timer=object:CountDownTimer1(timeLeftInMillis,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis=millisUntilFinished
                updateText()

            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()
                life--;
                textLife.setText(life.toString())
                textQuestion.setText("Times up!!")

            }

        }.start()

    }

    private fun updateText() {
        val remainTime=(timeLeftInMillis/1000).toInt()
        textTime.text= String.format(Locale.getDefault(),"%02d",remainTime)


    }

    private fun pauseTimer() {
        timer.cancel()
    }

    private fun resetTimer() {
        timeLeftInMillis=startTimerInMillis
        updateText()
    }
}