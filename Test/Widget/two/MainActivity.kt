package com.example.hw04_2_2017112823

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var tvName : EditText
    lateinit var tvEmail : EditText
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        tvName = findViewById<EditText>(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        button1 = findViewById(R.id.button1)

        button1.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입려")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            dlg.setView(dialogView)

            dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

            var myStr3 : String = tvName.text.toString()
            var myStr4 : String = tvEmail.text.toString()
            dlgEdtName.setText(myStr3)
            dlgEdtEmail.setText(myStr4)

            dlg.setPositiveButton("확인") { dialog, which ->


               var myStr1 : String = dlgEdtName.text.toString()
               var myStr2 : String = dlgEdtEmail.text.toString()
               tvName.setText(myStr1)
               tvEmail.setText(myStr2)
            }
            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1,null)
                toastText = toastView .findViewById<TextView>(R.id.toastText1)
               toastText.text = "취소했습니다"
                toast.view = toastView

               // var tMsg = Toast.makeText(applicationContext, "취소했습니다", Toast.LENGTH_LONG)

               var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay

                var x = (Math.random() * display.width).toInt()
               var y = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT
                                    , x, y)
                toast.show()
            }
            //dlg.setPositiveButton("확인",null)
           // dlg.setNegativeButton("취소",null)
            dlg.show()

        }
    }
}