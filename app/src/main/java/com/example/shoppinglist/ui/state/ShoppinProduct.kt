package com.example.shoppinglist.ui.state


import androidx.compose.runtime.Stable
import java.util.concurrent.atomic.AtomicInteger

data class ShoppingProduct(
    val productName: String,
    val key: Int = identifier.incrementAndGet(), // (3)
    val checked: Boolean = false   // (1)
) {
    companion object { // (2)
        val identifier: AtomicInteger = AtomicInteger(0)  // (3)
        fun getDummyShoppingProducts() =
            List(4) { i -> ShoppingProduct(productName = "Producto $i") }
    }
}

/**
 * (1)
 * Antes checkedState era un MutableState, pero ahora al usar StateFlow, cada vez que se cambia algo
 * se copia entera la lista forzando que se detecte el cambio de estado por compleja que sea
 * la estructura interna. De hecho, por eso se declara como List y no como MutableList; el modelo
 * de estado que recibe StateFlow debe ser inmutable para garantizar que siempre se actualice
 * creando un elemento nuevo (con update).
 *
 *
 * (2)
 * Kotlin utiliza companion objects para encapsular miembros de clase (lo que en java serían static).
 * Se trata de un objeto que acompaña a la clase y por tanto contiene todos lo miembros de clase,
 * siendo ese objeto común a todos los objetos de la clase.
 * En este caso. El índice de identificadores es común a todos los objetos de la clase.
 *
 *
 * (3)
 * Variable autoincrementada
 * https://stackoverflow.com/questions/24305830/java-auto-increment-id
 * https://stackoverflow.com/questions/70309293/each-instance-of-class-worker-should-have-an-own-id-starting-at-1-and-get-inc
 *
 */