package presentation.viewmodel

import utils.Input
import data.TaskRepository
import domain.Priority
import domain.Task


class TaskViewModel(
    private val dataTask: TaskRepository,
    private val input: Input
    ) {

    //Añadir Tareas
    fun addTask(){
        println("\n-------------Tarea------------")
        //Para el input se llama a la funcion de input... para que el usuario noingrese texto en blanco.    
        val title = input.inputNotBlankOrNull("\nTitulo de la tarea")
        val description = input.inputNotBlankOrNull("\nDescripcion de la Tarea")
        var priority: Priority? = null
        while (priority == null){
            println("\nPrioridad: \n1. Alta\n2. Media \n3. Baja\n")
            print("Digite su opción: ")
            val input = readln().toIntOrNull() ?: 0
            when (input) {
                1 -> priority = Priority.ALTA 
                2 -> priority = Priority.MEDIA
                3 -> priority = Priority.BAJA
                else -> println( "Error: Digite el Literal/Numero de la opcion correspondiente\n" )
            }
        }

        print("\nPresione Enter para continuar: ")
        val exit = readln()
        ProcessBuilder("clear").inheritIO().start().waitFor()
        val id = (dataTask.getAllTasks().maxOfOrNull { it.id } ?: 0) + 1
        val newTask = Task(id,title,description,priority,false)
        dataTask.saveTask(newTask)
    
    }

    fun showList(){
        println("Listas")
    }

}
    
