package com.example.myapplication

import android.annotation.SuppressLint
import android.database.Observable
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.liys.dialoglib.LDialog


import entity.Greeter

import java.sql.DriverManager.println


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvOne:TextView
   private lateinit var tvTwo:TextView
   private lateinit var tvThree:TextView
    private val gee:Greeter  = Greeter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        tvOne = findViewById(R.id.tv1)
        tvTwo =  findViewById(R.id.tv2)
        tvThree = findViewById(R.id.tv3)

        gee.textViewToText(tvOne,"这是我的矩形")
        gee.textViewToText(tvTwo,"我不承认是你的")
        gee.textViewToText(tvThree,"全都是我的")

        tvOne.setOnClickListener(this)

        gee.name = "应该是这样的啊"

        if(TextUtils.isEmpty(gee.name)){
            println("没有这个东西！")
        }else{
            println(gee.name)
            println(gee.name)
            println(gee.name)
            println(gee.name)
            println(gee.name)
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        if(ev?.actionMasked == MotionEvent.ACTION_DOWN){
            return true
        }

        return super.dispatchTouchEvent(ev)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event?.actionMasked == MotionEvent.ACTION_DOWN){
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
