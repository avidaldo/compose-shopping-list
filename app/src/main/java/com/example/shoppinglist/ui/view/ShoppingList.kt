package com.example.shoppinglist.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppinglist.data.ShoppingProduct


@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onChangeChecked: (Int) -> Unit,  // (1)
    onRemoveItem: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
/*        items(items = list, key = { it.key }) {
            ShoppingListItem(
                productName = it.productName,
                checked = it.checked,
                onChangeChecked = { onChangeChecked(it) },  // (1)
                onClose = { onRemoveItem(it) })
        }*/
        itemsIndexed(items = list) { index, product ->
            ShoppingListItem(
                productName = product.productName,
                checked = product.checked,
                onChangeChecked = { onChangeChecked(index) }, // (1)
                onClose = { onRemoveItem(product) })
        }
    }
}


/**
 * (1) Ya no se puede pasar simplemente el propio objeto ShoppingProduct al que apunta el
 * índice de la lista. Necesitamos pasar el índice para poder asignar en este un nuevo objeto,
 * generando así una modificación observable en el estado, para que la vista se recomponga.
 *
 *
 */