package ui

class TerminalView{

    fun showMenu(option:Int){
        return when(option){
            1 -> showMainMenu()
            else -> println("Error")
        }
    }
    
    private fun showMainMenu() {
        println("\n------------Menu-------------")
        //println("1. Agregar Tarea\n2. Listar Tareas\n3. Buscar Tarea\n4. Marcar Tarea Completa \n5. Eliminar Tarea\n6. Salir\n")
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

        print("\nDigite su opcion: ")
    }
    
}
