package utils

class Input{

    fun inputNumbers(): Int {
        do{
            print("\nDigite su opción: ")
            try{
                val input = readln()
                if (!input.isNullOrBlank())return input.toInt()
            } catch(e: NumberFormatException){
                println("Error: $e")
                println("Digite el indice númerico de la opción requerida.")
            } catch (e: Exception) {
                println(e)
            }
        } while(true)
    }

    fun inputNotBlankOrNull(promt:String): String {
        while(true){
            println(promt)//Imprime el mensaje recibito por parametro
            val input = readln() //Lee
            //Verifica que input no este vacio.
            if (!input.isNullOrBlank()){ 
                return input //Si no esta vacio retorna el input
            } else {
            // Sino imprime Error y continue el bucle
                println("Error: No puede estar en blanco, intente de nuevo")
            }
        }
    }
}

