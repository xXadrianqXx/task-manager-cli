package utils

import domain.Priority
import domain.Task

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

class ParserPrint{
    //Imprime la Lista correspondiente
    fun printTasks(list:List<Task>){

        if (list.isEmpty()) {
            if (list.isEmpty()) {
                    println("\n╔========╗")
                    println("║${" ".repeat(18)}📋 LISTA VACÍA${" ".repeat(18)}║")
                    println("╚========╝")
                    return
                }
        }

        list.forEachIndexed {index, task ->
            val state = if (task.state) "✔ Completa" else "✘ Incompleta"
            val prioridad = when (task.priority) {
                        Priority.ALTA  -> "Alta"
                        Priority.MEDIA -> "Media"
                        Priority.BAJA  -> "Baja"
                    }
            println("\n┌─────────────────────────────────────────────────┐")
            println("│ Tarea N°${index + 1} (ID: ${task.id})")
            println("├─────────────────────────────────────────────────┤")
            println("│ Título:      ${task.title}")
            println("│ Descripción: ${task.description}")
            println("│ Prioridad:   $prioridad")
            println("│ Estado:      $state")
            println("└─────────────────────────────────────────────────┘")
        }
    }
}
