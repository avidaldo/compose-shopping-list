package com.example.shoppinglist.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listatareas.R
import com.example.shoppinglist.ui.state.ShoppingListViewModel

@Composable
fun MainScreen() {
    val viewModel: ShoppingListViewModel = viewModel()  // (1)
    val shoppingList by viewModel.list.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            AddBlock { viewModel.add(it) }
            ShoppingList(
                list = shoppingList,
                onChangeChecked = { viewModel.changeChecked(it) },
                onRemoveItem = { viewModel.remove(it) },
            )
        }
    }
}
