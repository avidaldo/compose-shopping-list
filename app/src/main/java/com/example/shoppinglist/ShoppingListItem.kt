package com.example.shoppinglist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.listatareas.R


@Composable
fun ShoppingListItem(
    elementName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier.background(MaterialTheme.colors.secondary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = elementName,
                Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.close))
            }
        }

    }
}
