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
        println("1. Agregar Tarea\n2. Listar Tareas\n3. Buscar Tarea\n4. Marcar Tarea Completa \n5. Eliminar Tarea\n6. Salir\n")

        print("Digite su opcion: ")
    }
    
}
