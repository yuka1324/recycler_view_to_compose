package com.example.myapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Item
import com.example.myapplication.R

class RecyclerViewAdapter (
    private val itemData: MutableList<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemId: TextView = itemView.findViewById(R.id.item_id_text)
        var itemName: TextView = itemView.findViewById(R.id.item_name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = itemData[position]
        holder.itemId.text = item.id
        holder.itemName.text = item.name
    }

    override fun getItemCount() : Int = itemData.size
}