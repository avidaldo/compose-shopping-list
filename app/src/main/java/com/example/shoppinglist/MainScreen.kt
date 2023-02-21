package com.example.shoppinglist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listatareas.R

@Composable
fun MainScreen() {

    val viewModel: ShoppingListViewModel = viewModel()

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            AddBlock { viewModel.add(ShoppingProduct(it)) }
            ShoppingList(
                list = viewModel.list,
                onCloseItem = { viewModel.remove(it) },
            )

        }


    }
}

