package com.example.activity.application

import android.app.Application
import android.content.Context

class MyApp : Application (){
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this

    }
    companion object{
        private  lateinit var currentApplication: Context


        fun currentApplication():Context{
            return currentApplication
        }
    }

}