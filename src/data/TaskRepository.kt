package data

import domain.Task

fun saveTask(task: Task){
    save(toStringTask(task))
}


fun loadRepository(){
// Recibimos la Lista Natural y esta manipularemos.
    val tasks = loadTask()
    println(tasks)

    
}


//Carga la lista tal y como esta en el archivo y los mete en una lista convertidos en Tareas
fun loadTask(): List<Task>{
    val tasks:MutableList<Task> = mutableListOf()

    //Si estaba vacio o no existia devuelve una lista vacia. 
    val lines = load()?.split("\n") ?: return emptyList()

    var complete = 0
    var errors = 0
    // Aqui recorremos la lista una por una y mandamos ala funcion Mapper que nos devuelva una clase tarea.
    for (line in lines){
    //Preguntamos que la linea no este en blanco y si lo esta que salte esta linea.
        //Enviamos la linea a toTask y esta nos devuelve un Task
        println("1.$line")
        val task = toTask(line)
        if (task != null){
            tasks.add(task)
            complete++
            
        } else {errors++}
    }

    println("Tareas Cargadas: $complete\nErrores en la Carga: $errors")

    return tasks.toList()
    
}
