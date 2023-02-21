package com.example.shoppinglist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    private val _list = mutableStateListOf<ShoppingProduct>()
    val list get() = _list


    fun remove(item: ShoppingProduct) {
        _list.remove(item)
    }

    fun add(item: ShoppingProduct){
        _list.add(item)
    }

}
