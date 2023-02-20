package com.example.shoppinglist

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    private val _list = getFakeShoppingProducts().toMutableStateList()
    val list get() = _list  // (1)


    fun remove(item: ShoppingProduct) {
        _list.remove(item)
    }

    fun changeProductChecked(item: ShoppingProduct){
        //list.find {it.key=item.key}?.let {  }
        item.checked = !item.checked
    }

}

/**
 * Definimos una propiedad interna _list que solo será modificable desde dentro del ViewModel y
 * otra list, que será la que expongamos hacia fuera (pública y de solo lectura).
 * Esto se hace para no poder modificar la lista desde fuera del ViewModel.
 *
 * list es una API pública, mientras que _list es un detalle de implementación.
 *
 * https://developer.android.com/codelabs/jetpack-compose-state#11
 * https://stackoverflow.com/a/68016417
 *
 */