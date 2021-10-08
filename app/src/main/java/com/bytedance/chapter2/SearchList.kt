package com.bytedance.chapter2

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(content: String) {

        (itemView as TextView).text = content

    }

}

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private val items = arrayListOf<String>()

    //  创建 ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(TextView(parent.context))
    }

    //  更新 ViewHolder
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])
    }

    //  控制列表项个数
    override fun getItemCount(): Int {
        return items.size
    }

    //  刷新列表项
    fun updateItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}