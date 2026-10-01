package com.example.unidad02practica02

fun main(){

    //Cadena de texto csv
    val csv = """nombre,nota1,nota2,nota3
        Ana,7,8,9
         Luis,5,6,4
          Marta,9,10,8"""

    //Separo la cadena por salto de linea
    val lineas = csv.split("\n")

    //Recorro cada linea
    for (linea in lineas){
        if(lineas.indexOf(linea) != 0){ //Me salto la primera linea que es el encabezado
        val elementos =linea.split(",")//Separo nombres y notas
            //Asigno nombres y notas a una constante
        val nombre = elementos[0].trim()
        val nota1 = elementos[1].toInt()
        val nota2 = elementos[2].toInt()
        val nota3 = elementos[3].toInt()

        val media = (nota1 + nota2 + nota3)/3 //Se calcula la media

            //la constante calificacion mostrara un mensaje segun su nota
        val calificacion = when{
            media<5 -> "Suspenso" //Suspenso si la media es menor a 5
            media in 5..6 -> "Aprobado"// Aprobado si esta entre 5 y 6
            media in 7..8 -> "Notable"//Notable si esta entre 7 y 8
            media in 9..10 ->"Sobresaliente"//Sobresaliente si esta entre 9 y 10
            else -> "Nota no valida"
        }
            //Se muestra la calificacion.
        println("Nombre: $nombre \n notas: $nota1,$nota2,$nota3 \n media: $media \n Calificacion: $calificacion  ")

     }
    }
}