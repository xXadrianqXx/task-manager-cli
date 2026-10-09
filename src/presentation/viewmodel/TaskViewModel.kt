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
        
        val newList = dataTask.getAllTasks().toMutableList()

        newList.add(newTask)

        dataTask.updateDB(newList.toList())

        dataTask.updateList()
    }

    fun showList(){
        parser.printTasks(dataTask.getAllTasks())
    }

    private fun dialogOfUpdateDB(newList: MutableList<Task>):Int?{
    //Imprimimos instrucción
        print("Digite la ID de la Tarea: ")
        //Pedimos id de la trea a marcar
        val id = readln().toIntOrNull() ?: 0
//Verificamos que alguno de ellos exista. Sino existe vuelve al Menú Principal.
        if (!newList.any{it.id == id}) {
            println("Error: La ID digitada no coincide con ninguna Tarea.")
            print("\nPresione Enter para volver al Menú Principal: ")
            val n = readln()
            return null
        }
        
//Si existe obtenemos la pos en que se encuentra.
        val i = newList.indexOfFirst{it.id == id}

        val L = mutableListOf(newList[i])
        parser.printTasks(L)

        while(true){
            print("\nEstas seguro de querer realizar cambios?(s/n): ")
            
            val answer = readln().uppercase()
            if (answer== "S" || answer == "SI"){
                return i
            }
            if (answer== "N" || answer == "NO"){
                return null
            }
            
            println("\nError: Digite s o n según lo requiera.\n")
        }
    }
        
    fun updateTask(){
        //Cargamos la lista actual en una variable la cual vamos a modificar.
        val newList = dataTask.getAllTasks().toMutableList()
    //Buscamos la lista y la confirmacion para realizar cambios.
        val i = dialogOfUpdateDB(newList)
//Si i es null o no se aprobó los cambios o no se encontro la Tarea.
        if (i == null) {
            return
            ProcessBuilder("clear").inheritIO().start().waitFor()
        }
        
        //Copiamos,editamos y agregamos la tarea actualizada.
        newList[i] = newList[i].copy(state = !newList[i].state)

        dataTask.updateDB(newList.toList())
        print("\nLa Tarea ${i +1} se actualizo con exito! \nPresione enter para Volver al Menú Principal: ")
        val n = readln()
        ProcessBuilder("clear").inheritIO().start().waitFor()
        dataTask.updateList()
    }

    fun deleteTask(){
        val newList = dataTask.getAllTasks().toMutableList()
        val i = dialogOfUpdateDB(newList)
        if (i == null) {
            return
            ProcessBuilder("clear").inheritIO().start().waitFor()
        }

        newList.removeAt(i)

        dataTask.updateDB(newList)

        print("\nLa Tarea ${i +1} se elimino con exito! \nPresione enter para Volver al Menú Principal: ")
        val n = readln()
        ProcessBuilder("clear").inheritIO().start().waitFor()
        dataTask.updateList()
    }

}
    
