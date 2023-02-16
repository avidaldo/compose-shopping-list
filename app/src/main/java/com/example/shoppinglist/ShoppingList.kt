package com.example.shoppinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items


@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onCloseElement: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(list) { element ->
            ShoppingListItem(
                shoppingElement = element,
                onClose = {
                    onCloseElement(it)
                }
            )
        }
    }

}