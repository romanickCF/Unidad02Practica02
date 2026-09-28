package com.example.unidad02practica02

fun main(){
    val tareas= mutableListOf("Hacer deberes", "Sacar al perro", "Hacer la compra", "Lavar el coche")



    fun anadir(){
        println("Escribe la tarea que quieras añadir")
        val tarea = readln()
        if(tareas.add(tarea)){
            println("Tarea añadida correctamente")
        }else{
            println("No se ha podido añadir la tarea")
        }
    }

    fun listar(){
        println("===LISTA DE TAREAS===")
        for ((i,tarea) in tareas.withIndex()){
            println("${i + 1}. $tarea")
        }
        println()
    }

    fun pendientes(){
            println("===TAREAS PENDIENTES===")
        var hayPendientes = false
        for (tarea in tareas){
            if(!tarea.contains("[X]")){
                println(tarea)
                hayPendientes= true
            }
        }
        if(!hayPendientes){println("No hay tareas pendientes")}
        println()
    }
    fun pedirIndice() : Int{
        println("Indica el numero de la tarea")
        return readln().toInt()
    }

    fun completar(){
        val indiceReal = pedirIndice() -1

        if (indiceReal>= 0 && indiceReal<tareas.size){
            val tareaActual = tareas[indiceReal]
            tareas[indiceReal] = "[X] $tareaActual"
            println("Tarea marcada como completada")
        }else{
            println("El numero de tarea no existe")
        }
    }

    fun eliminar(){

        val indiceReal = pedirIndice() -1
        if (indiceReal>= 0 && indiceReal<tareas.size){
            tareas.removeAt(indiceReal)
            println("Tarea eliminada")
        }else{
            println("El numero de tarea no existe")
        }
    }

    //MENU
    var salir = false
while (!salir) {
    println(
        "==BIENVENIDO AL GESTOR DE TAREAS==\n " +
                "Selecciona una opcion\n" +
                "1.Listar Tareas\n" +
                "2.Anadir Tarea\n" +
                "3.Eliminar Tarea\n" +
                "4.Mostrar tareas pendientes.\n" +
                "5.Marcar tarea como completada\n" +
                "6.Salir\n"
    )

    val opcion = readln().toInt()

    when (opcion) {
        1 -> listar()
        2 -> anadir()
        3 -> eliminar()
        4 -> pendientes()
        5 -> completar()
        6 -> salir = true
        else -> println("Introduce un numero valido")
    }
}

}