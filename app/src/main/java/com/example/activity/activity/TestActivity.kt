package com.example.activity.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.activity.R


class TestActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

    }

    fun init() {
        recyclerView = findViewById(R.id.activity_test_recycler_view)

//        val layoutManager = LinearLayoutManager(this, 0, false)
//        //        瀑布流布局
//        val layoutManager1 = StaggeredGridLayoutManager(3, 1)
//        //          网格布局
//        val layoutManager2 = GridLayoutManager(this, 2)
//        recyclerView?.layoutManager = layoutManager
//        val com.example.com.example.com.example.activity.activity.com.example.activity.activity.adapter = CommonRecyclerAdapter()
//        recyclerView?.com.example.com.example.com.example.activity.activity.com.example.activity.activity.adapter = com.example.com.example.com.example.activity.activity.com.example.activity.activity.adapter
    }


}