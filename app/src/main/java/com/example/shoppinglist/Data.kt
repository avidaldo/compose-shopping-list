package com.example.shoppinglist


data class ShoppingProduct(val name: String, val checked: Boolean = false)

fun getFakeShoppingProducts() = List(30) { i -> ShoppingProduct("Producto $i") }

