package com.example.shoppinglist.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ShoppingList(
    list: Set<String>,
    onRemoveItem: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = list.toList()) {
            ShoppingListItem(
                productName = it,
                onClose = { onRemoveItem(it) })
        }
    }
}
