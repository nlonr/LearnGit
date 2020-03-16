package com.example.activity.entity

import android.widget.TextView
import java.sql.DriverManager.println

class Greeter {
    var img:Int? = null
    var name:String? = null
    var pw:String? = null
    var code:String? = null
    var extra:String? = null

    constructor()

    constructor(img:Int?,name:String,pw:String,code:String,extra:String){
        this.img = img;
        this.name = name
        this.pw = pw
        this.code = code
        this.extra = extra
    }



    fun getName(){
        println("Hello, Word!")

    }

    fun textViewToText( view:TextView,  text:String){
        view.text = text
    }

}