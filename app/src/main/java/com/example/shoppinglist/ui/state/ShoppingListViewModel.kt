package com.example.shoppinglist.ui.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    private val _list = mutableStateListOf<ShoppingProduct>()
    //    .apply { addAll(getDummyShoppingProducts()) }  // (2)
    val list get() = _list  // (1)

    fun add(item: ShoppingProduct) {
        _list.add(item)
    }

    fun remove(item: ShoppingProduct) {
        _list.remove(item)
    }

    fun changeChecked(product: ShoppingProduct) {
        product.checked = !product.checked
    }

}

/**
 * (1)
 *
 * Definimos una propiedad interna _list que solo será modificable desde dentro del ViewModel y
 * otra list, que será la que expongamos hacia fuera (pública y de solo lectura).
 * Esto se hace para no poder modificar la lista desde fuera del ViewModel.
 *
 * list es una API pública, mientras que _list es un detalle de implementación.
 *
 * https://developer.android.com/codelabs/jetpack-compose-state#11
 * https://stackoverflow.com/a/68016417
 *
 *
 * (2)
 *
 * Añadimos elementos para poder testear. Es importante hacerlo así si queremos poder añadir
 * usar la misma lista y añadirle elementos.
 * Si usamos getDummyShoppingProducts().toMutableList(), la primera función añade elementos usando
 * unas claves, pero al convertir a MutableList es otro objetov y no se mantiene la misma lista de
 * AtomicInteger.
 *
 * La scope function apply crea un contexto donde "this" es el objeto desde el que se llama y que
 * devuelve el mismo objeto después de ser modificado al ejecutar el bloque. Necesitamos utilizarla
 * para poder modificar la lista pero asignarla a la variable _list. La alternativa en estilo
 * imperativo sería:

private var _list = mutableStateListOf<ShoppingProduct>()
init { list.addAll(getDummyShoppingProducts()) }

 * donde init define un bloque que se ejecuta al instanciar la clase (simplifica sobreescribir el
 * constructor)
 *
 */
