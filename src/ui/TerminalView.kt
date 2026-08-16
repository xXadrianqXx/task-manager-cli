fun MenuPrincipal(){
    var onApp = true
    do{
        println("\n------------Menu-------------")
        println("1. Agregar Tarea\n2. Listar Tareas\n3. Buscar Tarea\n4. Marcar Tarea Completa \n5. Eliminar Tarea\n6. Salir\n")
        print("Digite su opcion: ")
        val input = readLine()?.toIntOrNull() ?: 0
        when (input){
            1 -> addTask(listOfTasks)
            2 -> listTasks(listOfTasks)
            3 -> findTask(listOfTasks)
            4 -> chooseCompleteTask(listOfTasks)
            5 -> removeTask(listOfTasks)
            6 -> onApp = false
            else -> println("\nERROR: Digite el Literal/Numero de la opcion correspondiente\n")
        }
    } while(onApp)
}
