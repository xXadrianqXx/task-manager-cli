package ui

import utils.Input

class TerminalView{
    
    fun showMainMenu(): List<() ->List> {
    
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


    }

    private fun listTasks(){
        println("""
            |---------------------------|
            |1. Listar                  |
            |2. Configuracion de Listar |
            |3. Salir                   |
            |___________________________|
         """.trimIndent())
    }

    private fun searchTasks() {
    
        println("""
            |---------------------------|
            |1. Agregar Tareas          |

        """.trimIndent())
        
    }
    
}
