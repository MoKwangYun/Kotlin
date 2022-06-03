package com.example.hw06


import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    lateinit var ibZoomin : ImageButton
    lateinit var ibZoomout : ImageButton
    lateinit var ibRotate : ImageButton
    lateinit var ibBright : ImageButton
    lateinit var ibDark : ImageButton
    lateinit var ibB : ImageButton
    lateinit var ibE : ImageButton
    lateinit var graphicView : MyGraphicView



    companion object {
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
        var blur : Boolean = false
        var embos : Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "미니 포토샵"

        var pictureLayout = findViewById<LinearLayout>(R.id.pictureLayout)
        graphicView = MyGraphicView(this)
        pictureLayout.addView(graphicView)

        clickIcons()
    }

    fun clickIcons() {
        ibZoomin = findViewById<ImageButton>(R.id.ibZoomin)
        ibZoomin.setOnClickListener {
            sX = sX + 0.2f
            sY = sY + 0.2f
            graphicView.invalidate()
        }

        ibZoomout = findViewById<ImageButton>(R.id.ibZoomout)
        ibZoomout.setOnClickListener {
            sX = sX - 0.2f
            sY = sY - 0.2f
            graphicView.invalidate()
        }

        ibRotate = findViewById<ImageButton>(R.id.ibRotate)
        ibRotate.setOnClickListener {
            angle = angle + 20
            graphicView.invalidate()
        }

        ibBright = findViewById<ImageButton>(R.id.ibBright)
        ibBright.setOnClickListener {
            color = color + 0.1f
            graphicView.invalidate()
        }

        ibDark = findViewById<ImageButton>(R.id.ibDark)
        ibDark.setOnClickListener {
            color = color - 0.1f
            graphicView.invalidate()
        }

        ibB = findViewById<ImageButton>(R.id.ibB)
        ibB.setOnClickListener {

            if (blur == false)
                blur = true
            else
                blur = false
            graphicView.invalidate()

        }

        ibE = findViewById(R.id.ibE)
        ibE.setOnClickListener{
            if (embos == false)

                embos = true
            else
                embos = false
            graphicView.invalidate()
        }
    }

    class MyGraphicView(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            var cenX = this.width / 2f
            var cenY = this.height / 2f
            canvas!!.scale(sX, sY, cenX, cenY)
            canvas!!.rotate(angle, cenX, cenY)

            val paint = Paint()
            var bMask : BlurMaskFilter
            var eMask : EmbossMaskFilter

            var sr1 : Float = (1 - color) * 0.21f
            var sr2 = (1 - color) * 0.71f
            var sr3 = (1 - color) * 0.072f
            val array = floatArrayOf(
                sr1 + color,     sr2,      sr3,      0f,     0f,
                sr1,     sr2 + color,      sr3,      0f,     0f,
                sr1,     sr2,      sr3 + color,      0f,     0f,
                0f,     0f,      0f,      1f,     0f)
            val cm = ColorMatrix(array)
            if (satur == 0f) cm.setSaturation(satur)
            paint.colorFilter = ColorMatrixColorFilter(cm)

            var picture = BitmapFactory.decodeResource(resources,R.drawable.lena256)
            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f

            if(blur == true){
                bMask = BlurMaskFilter(30f,BlurMaskFilter.Blur.NORMAL)
                paint.maskFilter = bMask

            }

            if(embos == true){
                eMask = EmbossMaskFilter(floatArrayOf(3f, 3f, 3f),0.5f, 5f,10f)
                paint.maskFilter = eMask
               
            }

            canvas!!.drawBitmap(picture, picX, picY, paint)

            picture.recycle()
        }
    }
}
