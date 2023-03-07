package com.example.shoppinglist

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class ShoppingProduct(val key: Int, val name: String, initialChecked: Boolean = false) {
    var checked by mutableStateOf(initialChecked)
}

/**
 * Ahora la clase ShoppingProduct mantiene la definición de key y name como propiedades inmutables
 * en su constructor primario, pero checked pasa a ser una propiedad mutable que podrá ser
 * modificada desde el viewModel. La alternativa sería eliminar y añadir de nuevo un elemento cuando
 * este se modifica.
 */


fun getFakeShoppingProducts() = List(30) { i -> ShoppingProduct(i, "Producto $i") }

/* La misma función estilo Java: */
/*
fun getFakeShoppingProducts(): List<ShoppingProduct> {
    var lista = List(30) { i -> ShoppingProduct(i, "Producto $i") }
    return lista
}
*/

