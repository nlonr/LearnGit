package com.example.activity.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.activity.R
import com.example.activity.R.layout.dialog_confirm
import com.example.activity.adapter.FruitAdapter
import com.example.activity.entity.Greeter
import com.example.activity.myself.CommonRecyclerAdapter


class TestActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private val mData: List<Greeter>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

    }

    fun init() {
        recyclerView = findViewById(R.id.activity_test_recycler_view)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //        瀑布流布局
//        val layoutManager1 = StaggeredGridLayoutManager(3, 1)
        //          网格布局
//        val layoutManager2 = GridLayoutManager(this, 2)
        recyclerView?.layoutManager = layoutManager
//        val adapter = FruitAdapter(this,mData,R.layout_common_item.dialog_common)
//        recyclerView?.adapter = adapter
    }


}