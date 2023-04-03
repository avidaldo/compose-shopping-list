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
                add(item) }
        } // TODO: ¿cómo hago que la función devuelva el resultado del add?
    }

    fun add(productString: String) =
        if (list.value.none { productString == it.productName }) {  // TODO: con Set
            add(ShoppingProduct(productString))
            true
        } else false


    fun remove(item: ShoppingProduct) {  // TODO: lo normal sería recibir la key... pero funciona
        _list.update {
            it.toMutableList().apply { remove(item) }
        }
    }

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

/**
 * (1)
 * Antes checkedState era un MutableState. Al usar StateFlow, cada vez que se cambia algo se crea
 * una copia entera de la lista forzando que se detecte el cambio de estado por compleja que sea
 * la estructura interna. De hecho, por eso se declara como List y no como MutableList; el modelo
 * de estado que recibe StateFlow debe ser inmutable para garantizar que siempre se actualice
 * creando un elemento nuevo (con update).
 *
 * Por el mismo motivo, lo que se recibe no debe ser la TODO...
 *
 */
