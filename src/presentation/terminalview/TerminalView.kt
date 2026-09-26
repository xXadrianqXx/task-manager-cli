package presentation.terminalview 

import utils.Input


class TerminalView{

    var currentList: Map<Int, () -> Boolean> = mapOf(1 to ::listTasks)
    
    init{
        showMainMenu()
    }

    
    
    
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

        val list = mapOf(1 to ::listTasks, 2 to ::searchTasks, 3 to ::exit)
        currentList = list

        return true

    }

    fun listTasks(): Boolean{
        println("""
            |---------------------------|
            |1. Listar                  |
            |2. Configuracion de Listar |
            |3. Salir                   |
            |___________________________|
         """.trimIndent())
        val list = mapOf(1 to ::showMainMenu)
        currentList = list

        return true
    }

    fun searchTasks(): Boolean {
    
        println("""
            |---------------------------|
            |1. Agregar Tareas          |

        """.trimIndent())
        val list = mapOf(1 to ::showMainMenu) 
        currentList = list

        return true
    }

    fun exit(): Boolean{
        return false
    }
    
}
