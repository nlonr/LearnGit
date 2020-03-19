package com.example.nlonr.activity


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nlonr.R
import com.example.nlonr.entity.Greeter
import com.example.nlonr.mylibrary.CacheUtils
import com.example.nlonr.mylibrary.getImageCacheAsyncTask
import java.sql.DriverManager.println


/**
 * px=dp*(dpi/160)
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvOne: TextView
    private lateinit var tvTwo: TextView
    private lateinit var tvThree: TextView
    private lateinit var imgTest: ImageView
    private val gee: Greeter = Greeter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        tvOne = findViewById(R.id.tv1)
        tvTwo = findViewById(R.id.tv2)
        tvThree = findViewById(R.id.tv3)
        imgTest = findViewById(R.id.img_test)

        gee.textViewToText(tvOne, "这是我的矩形")
        gee.textViewToText(tvTwo, "我不承认是你的")
        gee.textViewToText(tvThree, "全都是我的")

        tvOne.setOnClickListener(this)

        gee.name = "应该是这样的啊"

        if (TextUtils.isEmpty(gee.name)) {
            println("没有这个东西！")
        } else {
            println(gee.name)
        }

        CacheUtils.setSpannableString(tvOne, "马化腾是我儿子", 1, 3)
        getImageCacheAsyncTask(this, imgTest)

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        if (ev?.actionMasked == MotionEvent.ACTION_DOWN) {
            return true
        }

        return super.dispatchTouchEvent(ev)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event?.actionMasked == MotionEvent.ACTION_DOWN) {
            return true
        }

        return super.onTouchEvent(event)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val xdpi = resources.displayMetrics.xdpi
        val ydpi = resources.displayMetrics.ydpi
        tvOne.text = "宽度：$xdpi    高度：$ydpi"

    }

}
