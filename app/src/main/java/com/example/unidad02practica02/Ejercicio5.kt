package com.example.unidad02practica02

fun main() {
    // 1. Creo el mapa mutable con claves tipo "A1", "A2"... y valores Boolean?
    // false = disponible, true = ocupado, null = no existe
    val asientos = mutableMapOf<String, Boolean?>()
    val filas = listOf('A', 'B', 'C', 'D', 'E') // 5 filas (A-E)

    // Inicializamos las 5 filas y 5 asientos por fila como disponibles (false)
    for (fila in filas) {
        for (col in 1..5) {
            asientos["$fila$col"] = false
        }
    }

    var salir = false

    // Bucle principal del menú
    while (!salir) {
        println("\n--- CINE ---")
        println("1. Mostrar mapa")
        println("2. Reservar asiento")
        println("3. Cancelar reserva")
        println("4. Salir")
        print("Elige una opción: ")


        try {
            val entrada = readln()

            // Si no se puede convertir a Int, devuelve null y el operador '?:' asigna un 0
            val opcion = entrada.toIntOrNull() ?: 0

            when (opcion) {
                1 -> mostrarMapa(asientos, filas)
                2 -> gestionarReserva(asientos, reservar = true)
                3 -> gestionarReserva(asientos, reservar = false)
                4 -> {
                    println("¡Gracias por usar el sistema de reservas!")
                    salir = true
                }
                else -> println("Opción no válida. Introduce un número del 1 al 4.")
            }
        } catch (e: Exception) {
            println("Ha ocurrido un error inesperado: ${e.message}")
        }
    }
}

// Función para mostrar el mapa visual de la sala
fun mostrarMapa(asientos: Map<String, Boolean?>, filas: List<Char>) {
    println("\n--- MAPA DE LA SALA ---")
    println("L: Libre | X: Ocupado | -: No existe")
    print("   ")
    for (i in 1..5) print("$i ")
    println()

    for (fila in filas) {
        print("$fila  ")
        for (col in 1..5) {
            val clave = "$fila$col"

            // Uso el operador elvis  para manejar por seguridad si el valor es null
            val estado = asientos[clave]

            val simbolo = when (estado) {
                false -> "L" // Disponible
                true -> "X"  // Ocupado
                null -> "-"  // No existe
            }
            print("$simbolo ")
        }
        println()
    }
}

// Función unificada para reservar o cancelar asientos
fun gestionarReserva(asientos: MutableMap<String, Boolean?>, reservar: Boolean) {
    print("Introduce el código del asiento (ej. A1): ")
    val asiento = readln().uppercase().trim()

    try {
        val estadoActual = asientos[asiento]

        if (estadoActual == null) {
            println("Error: El asiento '$asiento' no existe en este cine.")
            return
        }

        // 2. Si pasa el filtro, gestionamos la reserva o la cancelación
        if (reservar) {
            if (estadoActual) {
                println(" El asiento $asiento ya está ocupado.")
            } else {
                asientos[asiento] = true
                println(" ¡Asiento $asiento reservado con éxito!")
            }
        } else {
            if (!estadoActual) {
                println("⚠ El asiento $asiento ya estaba libre.")
            } else {
                asientos[asiento] = false
                println(" ¡Reserva del asiento $asiento cancelada con éxito!")
            }
        }
    } catch (e: Exception) {
        println(" Error al procesar el asiento: ${e.message}")
    }
}