package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list = MutableStateFlow(listOf<ShoppingProduct>())  // (1)
    // TODO: getDummyShoppingProducts()
    val list = _list.asStateFlow()

    private fun add(item: ShoppingProduct) {
        _list.update {
            it.toMutableList().apply {
                add(item)
            }
        } // TODO: ¿cómo hago que la función devuelva el resultado del add?
    }

    fun add(productString: String) =
        if (list.value.none { productString == it.productName }) {  // TODO: con Set
            add(ShoppingProduct(productString))
            true
        } else false


    fun remove(key: Int) {
        _list.update { currentState ->
            currentState.toMutableList().apply {
                find { it.key == key }?.also { remove(it) }
                    ?: throw RuntimeException("List element not found")
            }
        }
    }

/*    fun remove(item: ShoppingProduct) {  // TODO: también funciona así
        _list.update {
            it.toMutableList().apply { remove(item) }
        }
    }*/

    fun changeChecked(key: Int) {
        _list.update { currentState ->
            currentState.toMutableList().apply {
                find { it.key == key }?.apply {
                    this.checked = !this.checked
                } ?: throw RuntimeException("List element not found")

            }
        }
    }

/*    fun changeChecked(item: ShoppingProduct) {
        _list.update { currentState ->
            currentState.toMutableList().apply {
                    item.checked = !item.checked
            }
        }
    }*/

}


/**
 * (1) Dentro del StateFlow, se declara como List y no como MutableList; el modelo
 * de estado que recibe StateFlow debe ser inmutable para garantizar que siempre se actualice
 * creando un elemento nuevo (con update).
 */