package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Item
import com.example.myapplication.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        activity?.title = "This is RecyclerView layout"

        val itemListRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(view.context)
        val adapter = RecyclerViewAdapter(createDummyDataList())

        itemListRecyclerView.layoutManager = linearLayoutManager
        itemListRecyclerView.adapter = adapter

        itemListRecyclerView.addItemDecoration(DividerItemDecoration(view.context, linearLayoutManager.orientation))

        return view
    }

    private fun createDummyDataList(): MutableList<Item> {
        val itemList: MutableList<Item> = ArrayList()
        val item = Item("001", "test name")

        var i = 0
        while (i < 20) {
            i++
            itemList.add(item)
        }
        return itemList
    }
}