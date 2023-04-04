package com.example.shoppinglist.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.concurrent.atomic.AtomicInteger

data class ShoppingProduct(
    val productName: String,
    val key: Int = identifier.incrementAndGet(), // (3)
) {
    var checked by mutableStateOf(false)

    companion object { // (2)
        val identifier: AtomicInteger = AtomicInteger(0)  // (3)

        fun getDummyShoppingProducts() =
            List(4) { i -> ShoppingProduct(productName = "Producto $i") }
    }
}

/**
 *
 * (2) Kotlin utiliza companion objects para encapsular miembros de clase (lo que en java serían static).
 * Se trata de un objeto que acompaña a la clase y por tanto contiene todos lo miembros de clase,
 * siendo ese objeto común a todos los objetos de la clase.
 * En este caso. El índice de identificadores es común a todos los objetos de la clase.
 *
 *
 * (3) Variable autoincrementada
 * https://stackoverflow.com/questions/24305830/java-auto-increment-id
 * https://stackoverflow.com/questions/70309293/each-instance-of-class-worker-should-have-an-own-id-starting-at-1-and-get-inc
 *
 */