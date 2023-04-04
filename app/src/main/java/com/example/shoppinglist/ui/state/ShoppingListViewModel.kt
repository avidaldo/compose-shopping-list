package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list = MutableStateFlow(listOf<ShoppingProduct>())
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


/*    fun remove(item: ShoppingProduct) {  // TODO: lo normal sería recibir la key, pero también funciona así
        _list.update {
            it.toMutableList().apply { remove(item) }
        }
    }*/

    fun remove(key: Int) {
        _list.update { currentState ->
            currentState.toMutableList().apply {
                find { it.key == key }?.also { remove(it) }
                    ?: throw RuntimeException("List element not found")
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

    fun changeChecked(key: Int) {  // (1)
        //product.checked = !product.checked

        _list.update { currentState ->
            currentState.toMutableList().apply {
                find { it.key == key }?.apply {
                    this.checked = !this.checked
                } ?: throw RuntimeException("List element not found")

            }
        }
    }

}


