package com.example.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listatareas.R

@Composable
fun MainScreen() {

    val viewModel: ShoppingListViewModel = viewModel()  // (2)

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->

        ShoppingList(
            list = viewModel.list,
            onCloseElement = { viewModel.remove(it) },
            Modifier.padding(paddingValues),
        )
    }
}

/**
 * (2) Podemos acceder a nuestro ViewModel desde cualquier función composable llamando a la
 * función viewModel(), pero para ello necesitamos incorpor la dependencia (ver build.gradle).
 */