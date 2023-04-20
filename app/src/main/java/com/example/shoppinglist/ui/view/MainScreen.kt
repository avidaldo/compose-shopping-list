package com.example.shoppinglist.ui.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listatareas.R
import com.example.shoppinglist.ui.state.ShoppingListViewModel

@Composable
fun MainScreen() {
    val viewModel: ShoppingListViewModel = viewModel()  // (1)
    val shoppingList by viewModel.list.collectAsState()


    val context = LocalContext.current

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->

        Column(Modifier.padding(paddingValues)) {

            AddBlock {
                if (!viewModel.add(it)) {
                    Toast.makeText(context, "Ya exite", Toast.LENGTH_SHORT).show()
                }
            }
            ShoppingList(
                list = shoppingList,
                onChangeChecked = { viewModel.changeChecked(it) },
                onRemoveItem = { viewModel.remove(it) },
            )
        }
    }
}
