package com.example.shoppinglist.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.listatareas.R

@Composable
fun AddBlock(
    modifier: Modifier = Modifier,
    textButton: String = stringResource(R.string.add),
    addProduct: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text, onValueChange = { text = it }, Modifier.weight(1f)
        )
        Button(onClick = {
            if (text.isNotBlank()) addProduct(text)
            text = ""
            focusManager.clearFocus() // Esconde el teclado
        }) {
            Text(text = textButton)
        }
    }
}