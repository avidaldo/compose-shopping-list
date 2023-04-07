package com.example.shoppinglist.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listatareas.R
import com.example.shoppinglist.ui.state.ShoppingListViewModel

@Composable
fun MainScreen() {
    val viewModel: ShoppingListViewModel = viewModel()
    val shoppingList by viewModel.list.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            AddBlock { viewModel.add(it) }
            ShoppingList(
                list = shoppingList,
                onRemoveItem = { viewModel.remove(it) },
            )
        }
    }
}
