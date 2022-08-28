package com.example.myapplication.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.myapplication.Item

@Composable
fun ItemContent() {
    val items = remember { createDummyDataList() }
    LazyColumn(
    ) {
        items(
            items = items,
            itemContent = {
                itemsList(item = it)
            })
    }
}

fun createDummyDataList(): MutableList<Item> {
    val itemList: MutableList<Item> = ArrayList()
    val item = Item("001", "test name")

    var i = 0
    while (i < 20) {
        i++
        itemList.add(item)
    }
    return itemList
}