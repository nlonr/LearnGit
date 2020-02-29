package utils

import android.annotation.SuppressLint
import android.content.Context
import application.MyApp
import com.example.myapplication.R

@SuppressLint("StaticFieldLeak")
object CacheUtils {

    val context = MyApp.currentApplication()

    val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    fun sava(key:String?,value:String?){
        SP.edit().putString(key,value).apply()
    }

    fun get(key:String?):String?{
        return SP.getString(key,null)
    }







}