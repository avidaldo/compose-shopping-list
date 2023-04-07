package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list =  MutableStateFlow(setOf<String>())
    val list = _list.asStateFlow()

    fun add(item: String) : Boolean {
        _list.update {
            it.toMutableSet().apply {
                return@add add(item)
            }
        }
        return false
    }

    fun remove(item: String) {
        _list.update {
            it.toMutableSet().apply { remove(item) }
        }
    }



}
