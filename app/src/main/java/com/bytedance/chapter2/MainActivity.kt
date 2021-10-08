package com.bytedance.chapter2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  获取 RecyclerView 实例
        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = SearchAdapter()
        //  RecyclerView 绑定 Adapter
        list.adapter = adapter
        //  RecyclerView 绑定纵向布局管理器
        list.layoutManager = LinearLayoutManager(this)

        val items = arrayListOf<String>()
        for (i in 1..1000) {
            items.add("这是第 $i 个 item")
        }
        //  刷新列表项
        adapter.updateItems(items)

        val searchEdit = findViewById<SearchEditText>(R.id.search_edit)
        searchEdit.addTextChangedListener(object : SearchEditText.Listener {
            override fun onChanged(content: String) {
                //  过滤列表项
                val filters = items.filter {
                    it.contains(content)
                }
                adapter.updateItems(filters)
            }
        })

        //  点击取消按钮
        val cancel = findViewById<TextView>(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }

    }
}