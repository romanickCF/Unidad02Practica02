package com.example.unidad02practica02

fun main(){

    val texto = "Este es un texto de ejemplo"
    val conteoLetras = texto.lowercase() // Convierte todo a minúsculas
        .filterNot { it.isWhitespace() } //Ignora Espacios
        .groupingBy { it } //Agrupo cada char
        .eachCount()//Obtengo el numero de veces que se repite
        .entries // Obtengo las entradas (pares de clave-valor)
        .sortedByDescending { it.value } //  Ordeno de mayor a menor según el valor (frecuencia)
        .associateTo(mutableMapOf()) { it.key to it.value } // 4. Vuelve a convertirlo e un mutableMap() manteniendo el orden

    println(conteoLetras) //Muestro un mutableMap<Char,Int>

}
