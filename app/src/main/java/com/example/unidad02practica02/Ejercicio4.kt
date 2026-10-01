package com.example.unidad02practica02

fun main() {

    //Validaciones

    //no espacios
    fun tieneEspacios(password: String): Boolean{
        return password.any { it == ' ' || it == '\t' }
    }

    fun ochoCaracteres(password: String): Boolean{
        return password.length >= 8
    }//True si es mayor o igual a 8

    fun unaMayuscula(password: String): Boolean {
        return password.any { it.isUpperCase() }
    }//True si hay mayuscula

    fun unaMinuscula(password: String) : Boolean {
        return password.any { it.isLowerCase() }
    }//True si hay una minuscula

    fun unDigito(password: String): Boolean{
        return password.any{it.isDigit()}
    }//True si hay un digito

    fun caracterEspecial(password: String) : Boolean {
        return password.any{!it.isLetterOrDigit()}
    }//True si hay caracter especial


/*En vez de usar el when he hecho este metodo de forma que los errores se almacenan en una lista
   y se muestran todos los errores a la vez  */

    fun validarPassword(password: String): Boolean {
        val errores = mutableListOf<String>()

        if (!ochoCaracteres(password)) {
            errores.add("La contrasenia debe tener al menos 8 caracteres.")
        }
        if (!unaMayuscula(password)) {
            errores.add("La contrasenia debe contener al menos una letra mayuscula.")
        }
        if (!unaMinuscula(password)) {
            errores.add("La contrasenia debe contener al menos una letra minuscula.")
        }
        if (!unDigito(password)) {
            errores.add("La contrasenia debe contener al menos un numero.")
        }
        if (tieneEspacios(password)) {
            errores.add("La contrasenia no puede tener espacios")
        }
        if (!caracterEspecial(password)) {
            errores.add("La contrasenia debe tener un caracter especial")
        }

        if (errores.isNotEmpty()) {
            // Si hay errores, los imprimimos todos y devolvemos false
            errores.forEach { println(it) }
            return false
        } else {
            // Si la lista está vacía, pasó todas las pruebas
            println("Contrasenia valida!")
            return true
        }
    }


        var salir = false
    do {
        println("Introduce la contrasenia")
        val password = readln()
        if(validarPassword(password)){
            salir=true
        }
    }while (!salir)

}


