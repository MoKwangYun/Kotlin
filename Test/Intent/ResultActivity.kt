package com.example.hw07_1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"
        var iv0 : ImageView
        iv0 = findViewById(R.id.iv0)
        var imageFileId = arrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6,R.drawable.pic7,
            R.drawable.pic8, R.drawable.pic9)

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        // 9개의 TextView, RatingBar 객체배열
        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName.size)

        // 9개의 TextView, RatingBar ID 배열
        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)

        // TextView, RatingBar 개체 찾기.
        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }
        var tv0 : TextView
        tv0 = findViewById<TextView>(R.id.tv0)
        var max:Float = 0.0f

        // 각 TextVeiw 및 RatingBar에 넘겨 받은 값을 반영.
        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())

            if(voteResult[i].toFloat() > max)
            {
                max = voteResult[i].toFloat()
                tv0!!.setText(imageName[i])
                iv0.setImageResource(imageFileId[i])
            }
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

    }
}