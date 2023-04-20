package com.example.shoppinglist.ui.state

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShoppingProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {

    private val _list =  MutableStateFlow(listOf<ShoppingProduct>())  // (1)
    // TODO: getDummyShoppingProducts()
    val list = _list.asStateFlow()

    private fun add(item: ShoppingProduct) : Boolean{
        var result =  false
        _list.update {
            it.toMutableList().apply {
                result = add(item)
            }
        }
        return result
    }

    fun add(productString: String) : Boolean =
        if (list.value.none { productString == it.productName }) {
            add(ShoppingProduct(productString))
        } else false


    fun remove(key: Int) {
        _list.update { currentState ->
            currentState.toMutableList().apply {
                find { it.key == key }?.also { remove(it) }
                    ?: throw RuntimeException("List element not found")  // Offensive programming
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
                val index = indexOf(find { it.key == key })
                this[index] = this[index].copy(checked = !this[index].checked)
            }
        }
    }

}

/**
 * (1)
 * Dentro del StateFlow, se declara como List y no como MutableList; el modelo
 * de estado que recibe StateFlow debe ser inmutable para garantizar que siempre se actualice
 * creando un objeto nuevo (con update).
 *
 * Si checked no es una propiedad mutable, sus cambios no notificarán a Compose para recomposición.
 * por tanto, será necesario crear un nuevo elemento en el indice de la lista cuyo objeto queremos
 * modificar. No puede simplmenete modificarse el objeto sino crear uno nuevo (una nueva referencia,
 * por tanto) que tenga los nuevos valores (los mismos que tenía y checked cambiado). Por eso ahora
 * todas las propiedades de shoppingProduct son inmutables. No se cambiarán sino que se crearán
 * copias de los objetos para reasignar al indice de la lista donde estaba el anterior objeto. De
 * este modo, estamos generandom una modificación en la propia lista que sí es detectada por
 * mutableStateList y por tanto notificada a Compose, generando una recomposición en la vista.
 *
 */
