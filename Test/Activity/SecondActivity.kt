package com.example.hw07_2


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        var inIntent = intent
        var intval = inIntent.getIntExtra("cal", 0)
        if(intval == 1)
        {
            var hapValue1 = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0)
            var btnReturn = findViewById<Button>(R.id.btnReturn)
            btnReturn.setOnClickListener {
                var outIntent = Intent(applicationContext, MainActivity::class.java)
                outIntent.putExtra("Hap", hapValue1)
                setResult(Activity.RESULT_OK, outIntent)
                finish()
            }
        }
        else if(intval == 2)
        {
            var hapValue2 = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0)
            var btnReturn = findViewById<Button>(R.id.btnReturn)
            btnReturn.setOnClickListener {
                var outIntent = Intent(applicationContext, MainActivity::class.java)
                outIntent.putExtra("Hap", hapValue2)
                setResult(Activity.RESULT_OK, outIntent)
                finish()
            }
        }
        else if(intval == 3)
        {
            var hapValue3 = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0)
            var btnReturn = findViewById<Button>(R.id.btnReturn)
            btnReturn.setOnClickListener {
                var outIntent = Intent(applicationContext, MainActivity::class.java)
                outIntent.putExtra("Hap", hapValue3)
                setResult(Activity.RESULT_OK, outIntent)
                finish()
            }
        }
        else if(intval == 4)
        {
            var hapValue4 = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0)
            var btnReturn = findViewById<Button>(R.id.btnReturn)
            btnReturn.setOnClickListener {
                var outIntent = Intent(applicationContext, MainActivity::class.java)
                outIntent.putExtra("Hap", hapValue4)
                setResult(Activity.RESULT_OK, outIntent)
                finish()
            }
        }

    }
}