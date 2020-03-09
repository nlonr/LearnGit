package com.example.activity.entity

import android.widget.TextView
import java.sql.DriverManager.println

class Greeter {

    var name:String? = null
    var pw:String? = null
    var code:String? = null

    constructor()

    constructor(name:String,pw:String,code:String){
        this.name = name
        this.pw = pw
        this.code = code
    }



    fun getName(){
        println("Hello, Word!")

    }

    fun textViewToText( view:TextView,  text:String){
        view.text = text
    }

}