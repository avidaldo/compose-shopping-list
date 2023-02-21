package com.example.shoppinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onCloseItem: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = list, key = { it.id }) { element ->
            ShoppingListItem(elementName = element.name, onClose = { onCloseItem(element) })
        }
    }
}
