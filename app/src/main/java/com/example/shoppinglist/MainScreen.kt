package com.example.shoppinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.listatareas.R

@Composable
fun MainScreen() {

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) { paddingValues ->


        val list = remember { getFakeShoppingProducts().toMutableStateList() } // (1)
/*        val list = remember {
            mutableStateListOf<ShoppingProduct>().apply { addAll(getFakeShoppingProducts()) }
        }*/

        ShoppingList(
            list = list,
            onCloseElement = { list.remove(it) }, // (1)
            Modifier.padding(paddingValues),
        )
    }
}

/**
 * (1) Para poder eliminar elementos de la lista, podremos tener esta en un estado mutable
 * utilizando MutableListOf.
 *
 * Esta API no permite utilizar rememberSaveable. Habría formas de hacerlo, pero llegado a este
 * punto, lo recomendable es pasar a utilizar ViewModel.
 *
 * https://developer.android.com/codelabs/jetpack-compose-state#10
 */