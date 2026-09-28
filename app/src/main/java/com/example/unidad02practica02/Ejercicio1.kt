package com.example.unidad02practica02

fun main(){

    val csv = """nombre,nota1,nota2,nota3
        Ana,7,8,9
         Luis,5,6,4
          Marta,9,10,8"""

    val lineas = csv.split("\n")

    for (linea in lineas){
        if(lineas.indexOf(linea) != 0){
        val elementos =linea.split(",")
        val nombre = elementos[0].trim()
        val nota1 = elementos[1].toInt()
        val nota2 = elementos[2].toInt()
        val nota3 = elementos[3].toInt()

        val media = (nota1 + nota2 + nota3)/3

        val calificacion = when{
            media<5 -> "Suspenso"
            media in 5..6 -> "Aprobado"
            media in 7..8 -> "Notable"
            media in 9..10 ->"Sobresaliente"
            else -> "Nota no valida"
        }

        println("Nombre: $nombre \n notas: $nota1,$nota2,$nota3 \n media: $media \n Calificacion: $calificacion  ")

     }
    }
}