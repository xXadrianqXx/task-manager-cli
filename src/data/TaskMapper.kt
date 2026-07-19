package data

import domain.Priority
import domain.Task

//Funcion para convertir en Texto la Tarea
fun toStringTask(it: Task):String {
    val taskString =  "${it.id}|${it.title}|${it.description}|${it.priority}|${it.state}"
    
    return taskString
}



//Funcion que retorna null si no se puedo convertir a Task
fun toTask(text: String): Task? {
//Lee la lista y devuelve una lista(La lista depende de cuantos | habia)
    val parts  = text.split("|")
    // En caso de que haya algun error try catch no avizara que es.
    try {
        val task = Task(
            id = parts[0].trim().toInt(),
            title = parts[1].trim(),
            description = parts[2].trim(),
            priority = Priority.valueOf(parts[3].trim()),
            state = parts[4].trim().toBoolean()
        )
        //Si sale bien retornamos una Tarea
        return task
    } catch (e: Exception){
    // Si sale mal imprimimos el error
        println("Error: ${e.message}")
    }
    //Si sale mal retornamos null
    return null
}
