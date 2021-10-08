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

        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = SearchAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        val items = arrayListOf<String>()
        for (i in 1..1000) {
            items.add("这是第 $i 个 item")
        }
        adapter.updateItems(items)

        val searchEdit = findViewById<SearchEditText>(R.id.search_edit)
        searchEdit.addTextChangedListener(object : SearchEditText.Listener {
            override fun onChanged(content: String) {
                val filters = items.filter {
                    it.contains(content)
                }
                adapter.updateItems(filters)
            }
        })

        val cancel = findViewById<TextView>(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }

    }
}