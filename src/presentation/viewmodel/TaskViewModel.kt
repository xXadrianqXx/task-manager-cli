package presentation.viewmodel

import utils.Input
import utils.ParserPrint
import data.TaskRepository
import domain.Priority
import domain.Task


class TaskViewModel(
    private val dataTask: TaskRepository,
    private val input: Input,
    private val parser: ParserPrint
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

        dataTask.updateList()
    }

    fun showList(){
        parser.printTasks(dataTask.getAllTasks())
    }

    fun updateTask(){

    //Imprimimos instrucción
        print("Digite la ID de la Tarea: ")
        //Pedimos id de la trea a marcar
        val id = readln().toIntOrNull() ?: 0
        //Cargamos la lista actual en una variable la cual vamos a modificar.
        val newList = dataTask.getAllTasks().toMutableList()
//Verificamos que alguno de ellos exista. Sino existe vuelve al Menú Principal.
        if (!newList.any{it.id == id}) {
            println("Error: La ID digitada no coincide con ninguna Tarea.")
            print("\nPresione Enter para volver al Menú Principal: ")
            val n = readln()
            ProcessBuilder("clear").inheritIO().start().waitFor()
            return
        }
//Si existe obtenemos la pos en que se encuentra.
        val i = newList.indexOfFirst{it.id == id}
    //Si la lista ya esta actualizada, salir.
        if (newList[i].state == true){
            println("La Tarea ya esta completada.")
            print("\nPresione Enter para volver al Menú Principal: ")
            val n = readln()
            ProcessBuilder("clear").inheritIO().start().waitFor()
            return
        }
        //Copiamos,editamos y agregamos la tarea actualizada.
        newList[i] = newList[i].copy(state = true)
//Enviamos la nueva lista al repositorio.
        dataTask.updateTask(newList.toList())

        print("\nLa Tarea $id se actualizo con exito! \nPresione enter para Volver al Menú Principal: ")
        val n = readln()

        ProcessBuilder("clear").inheritIO().start().waitFor()

        dataTask.updateList()
    }

}
    
