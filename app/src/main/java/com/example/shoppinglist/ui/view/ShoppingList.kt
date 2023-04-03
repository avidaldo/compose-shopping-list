package com.example.shoppinglist.ui.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppinglist.ui.state.ShoppingProduct


@Composable
fun ShoppingList(
    list: List<ShoppingProduct>,
    onChangeChecked: (Int) -> Unit,
    onRemoveItem: (ShoppingProduct) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = list, key = { it.key }) { product ->
            ShoppingListItem(
                productName = product.productName,
                checked = product.checked,
                onChangeChecked = { onChangeChecked(product.key) },
                onClose = { onRemoveItem(product) })
        }
    }
}
