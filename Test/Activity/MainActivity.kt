package com.example.hw07_2


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"
        var rGroup1 = findViewById<RadioGroup>(R.id.rGroup1)
        var rb1 = findViewById<RadioButton>(R.id.rb1)
        var rb2 = findViewById<RadioButton>(R.id.rb2)
        var rb3 = findViewById<RadioButton>(R.id.rb3)
        var rb4 = findViewById<RadioButton>(R.id.rb4)

        rb1.setOnClickListener{
            rb1.isSelected = true
            rb2.isSelected = false
            rb3.isSelected  = false
            rb4.isSelected = false
        }
        rb2.setOnClickListener{
            rb1.isSelected = false
            rb2.isSelected = true
            rb3.isSelected  = false
            rb4.isSelected = false
        }
        rb3.setOnClickListener{
            rb1.isSelected = false
            rb2.isSelected = false
            rb3.isSelected  = true
            rb4.isSelected = false
        }
        rb4.setOnClickListener{
            rb1.isSelected = false
            rb2.isSelected = false
            rb3.isSelected  = false
            rb4.isSelected = true
        }
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
            if(rb1.isSelected == true)
                intent.putExtra("cal", 1)
            else if(rb2.isSelected == true)
                intent.putExtra("cal", 2)
            else if(rb3.isSelected == true)
                intent.putExtra("cal", 3)
            else if(rb4.isSelected == true)
                intent.putExtra("cal", 4)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "합계 :$hap", Toast.LENGTH_SHORT).show()
        }
    }
}