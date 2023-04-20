package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list = MutableStateFlow(setOf<String>())
    val list = _list.asStateFlow()

    fun add(item: String) : Boolean {
        var result = false
        _list.update {
            it.toMutableSet().apply {
                result = add(item)
            }
        }
        return result
    }

    fun remove(item: String) {
        _list.update {
            it.toMutableSet().apply { remove(item) }
        }
    }



}
