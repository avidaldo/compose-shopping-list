package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list = MutableStateFlow(setOf<String>())  // (1)
    val list = _list.asStateFlow()

    fun add(item: String) : Boolean { // (1)
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

/**
 * Los conjuntos (Set) no permiten elementos duplicados, por lo que en esta versión (ojo que
 * también he simplificado cada elemento a un mero String con el nombre del producto, ya no hay
 * checkBox) no será necesario comprobar manualmente si hay duplicados antes de añadir elementos.
 *
 * El propio método add del Set devolverá false cuando el nuevo elemento a añadir ya exista previamente
 * en el conjunto.
 *
 */
