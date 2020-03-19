package com.example.nlonr.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import com.example.nlonr.R
import com.example.nlonr.application.MyApp

@SuppressLint("StaticFieldLeak")
object CacheUtils {

    val context = MyApp.getInstance()
    val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String?): String? {
        return SP.getString(key, null)
    }

    fun setSpannableString(
        tv: TextView,
        string: String?,
        start: Int,
        end: Int
    ) {
        val spannableString = SpannableString(string)
        val relativeSizeSpan = RelativeSizeSpan(1.3f)
        spannableString.setSpan(relativeSizeSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        tv.text = spannableString
    }

}