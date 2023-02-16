package com.example.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.listatareas.R

@Composable
fun MainScreen() {
    val list = getFakeShoppingProducts()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->
        ShoppingList(
            list = list,
            onCloseElement = {},
            Modifier.padding(paddingValues),
        )
    }
}