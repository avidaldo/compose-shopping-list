package com.example.shoppinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onCloseElement: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(
            items = list,
            key = { it.key })  // (1)
        { element ->
            ShoppingListItem(
                shoppingElement = element,
                onClose = {
                    onCloseElement(it)
                }
            )
        }
    }
}

/**
 * (1) Sin claves, cada elemento de la lista estaba identificado por su índice (esto es, por su
 * posición).  El problema es que la variable de estado de cada elemento también se identifica con
 * cada elemento en cada posición. Al poder eliminar elementos, el check no se mantiene asociado con
 * cada elemento sino con la posición en que estaba. Al eliminar un elemento de la lista, su check
 * pasaría al siguiente. Para corregirlo tendremos que utilizar unas claves específicas en lugar de
 * la posición.
 *
 * Añado una propiedad key a cada ShoppingElement ya que cada clave debe ser distinta, y usando el
 * nombre tendríamos que comprobar explícitamente que un producto no exista ya (TODO).
 *
 */