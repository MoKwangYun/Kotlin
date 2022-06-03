package com.example.hw4_2017112823

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout : RelativeLayout
    lateinit var edit : EditText
    lateinit var img : ImageView
    lateinit var textview : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "HW04-1"
        baseLayout = findViewById(R.id.baseLayout)
        edit = findViewById(R.id.edit)
        img = findViewById<ImageView>(R.id.img)
        textview = findViewById<TextView>(R.id.textview)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when(item.itemId){
            R.id.item1 ->{

                var myStr : String =edit.text.toString()
                var a : Int = Integer.parseInt(myStr)
                img.rotation = (a.toFloat())
            }
            R.id.item2 ->{
                if(item.isChecked != true)
                    img.setRotation(0F)

                item.isChecked = !item.isChecked
                true

                //checked = "true"
                img.setImageResource(R.drawable.hanra)
                img.visibility = android.view.View.VISIBLE
                return true
            }

            R.id.item3 ->{
                if(item.isChecked != true)
                    img.setRotation(0F)

                item.isChecked = !item.isChecked
                true

                img.setImageResource(R.drawable.chuja)
                img.visibility = android.view.View.VISIBLE
                return true
            }

            R.id.item4 ->{
                if(item.isChecked != true)
                    img.setRotation(0F)

                item.isChecked = !item.isChecked
                true

                img.setImageResource(R.drawable.bum)
                img.visibility = android.view.View.VISIBLE
                return true
            }

        }

        return false
    }
}