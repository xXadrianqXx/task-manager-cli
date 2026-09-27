package presentation.terminalview 

import presentation.viewmodel.TaskViewModel


class TerminalView(private val viewModel: TaskViewModel){

    var currentList: Map<Int, () -> Boolean> = mapOf(1 to ::listTasks)
    
    init{
        showMainMenu()
    }

    
    
    //Muestra el menú principal.
    fun showMainMenu():Boolean {
    
        println("\n------------Menu-------------")
        
        println("""
            |---------------------------|
            |1. Agregar Tareas          |
            |2. Listar Tareas           |
            |3. Buscar Tareas           |
            |4. Marcar Tarea Completa   |
            |5. Eliminar Tareas         |
            |6. Salir                   |
            |___________________________|
        """.trimIndent())

        println("\n")

        val list = mapOf(1 to ::showAddTask,2 to ::listTasks, 3 to ::searchTasks, 6 to ::exit)
        currentList = list

        return true

    }

    fun showAddTask():Boolean {

        viewModel.addTask()

        return showMainMenu()
    }
    //Muestra el Menú para imprimir la lista.
    fun listTasks(): Boolean{
        println("""
            |---------------------------|
            |1. Listar                  |
            |2. Configuración           |
            |3. Menú Principal          |
            |___________________________|
         """.trimIndent())
        val list = mapOf(1 to ::showList,3 to ::showMainMenu)
        currentList = list

        return true
    }

    //Muestra la lista
    fun showList():Boolean{

        viewModel.showList()

        return listTasks()
    }

    fun searchTasks(): Boolean {
    
        println("""
            |---------------------------|
            |1. Buscar por ID           |
            |2. Buscar por nombre       |
            |3. Menú Principal          |
            |___________________________|

        """.trimIndent())
        val list = mapOf(3 to ::showMainMenu) 
        currentList = list

        return true
    }


    fun exit(): Boolean{
        return false
    }
    
}
