import java.io.File

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var priority: String,
    var state: Boolean = false
)

// ============= Menu y Funcion Principal ========

fun main(){
    var onApp = true
    val listOfTasks: MutableList<Task> = mutableListOf()

    println(loadTasks(listOfTasks))
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


fun updateFile(list:MutableList<Task>){
    val file = File("tareas.txt")
    val lines = list.joinToString("\n"){task ->"task.id}|${task.title}|${task.description}|${task.priority}|${task.state}" }
    println(lines)
    file.writeText(lines)
}

//Borra La Tarea
fun removeTask(list: MutableList<Task>){
    println("\nUNA VES REALIZADA LA OPERACION NO SE PODRA REHACER!")
    println("\n====== Eliminar Tarea =======")
    printTasks(sortedList(list,1))
    print("\nDigite la ID de la Tarea que desea Eliminar: ")
     val input = readLine()?.toIntOrNull() ?:0
     val task = list.find{it.id == input}
     if (task != null){
        println("La Tarea se elimino con exito")
        list.remove(task)
        updateFile(list)
         } else {println("\nERROR: ID Invalida\n")}                   

}


//Marcar Tarea Completa 
fun chooseCompleteTask(list: MutableList<Task>){
    printTasks(sortedList(list,1))

    print("\nDigite la ID de la Tarea Completada:")
    val input = readLine()?.toIntOrNull() ?:0
    val task = list.find{it.id == input}

    if (task != null) {
        task.state = true
        updateFile(list)
         } else {println("\nERROR: ID Invalida\n")}
    
}



//Guarda tareas en formato .txt
fun save(task:Task){
    //Ruta
    val file= File("tareas.txt")
    //No se usa joinToString porque es individual. Se convierte en texto manualmente
    val line = "${task.id}|${task.title}|${task.description}|${task.priority}|${task.state}"
    //Añade una linea nueva al archivo txt(No sobreescribe)
    file.appendText("$line\n")
}

//Cargar Tareas
fun loadTasks(list:MutableList<Task>): String{
    val file = File("tareas.txt")
    if (!file.exists()){
    //Si no existe retorna:
        return "\nNo hay datos para cargar\n"
    } else {
    //Lee lineas saltandose las lineas vacias.
        val line = file.readLines()
        for (n in line){
        //Devuelve una lista seprada por |
            val parts = n.split('|')
            val task = Task(
                id = parts[0].toInt(),
                title = parts[1],
                description = parts[2],
                priority = parts[3],
                state = parts[4].toBoolean()
                
            )
            //Añande los datos cargados a la lista
            list.add(task)
        }
    }
    return "\nLo datos de han cargado correctamente"
}
    

//Buscar Tarea 
fun findTask(list: MutableList<Task>){
    var findOn = true
    do{
    //Imprimir Menu    
        println("\n" + "=".repeat(30))
        println("---------Buscar Tarea-----------")
        println("1. Buscar por ID\n2. Buscar por Titulo\n3. Volver al Menu Principal")
        print("\nDigite su opcion: ")//Input de la opcion
        val input = readLine()?.toIntOrNull() ?: 0
        when (input){
            1 -> searchForId(list)
            2 -> searchForTitle(list)
            3 -> findOn = false
            else -> println("\nERROR: Digite el Literal/Numero de la opcion  correspondiente\n")
        }
    }while(findOn)
     
}

//Buscar por el Titulo
fun searchForTitle(list: MutableList<Task>){
    print("\nDigite el titulo de la Tarea: ")
    val input = readLine() ?: ""
    //Filtra y----------
    val results = list.filter{it.title.contains(input, ignoreCase = true)}.toMutableList()
    if (!results.isEmpty()){
        println("\n" + "=".repeat(30))
        println("Resultado/s")
        printTasks(results)
        
    } else { println("\nNo se encontraron Resultados\n")}
}

//Buscar por id
fun searchForId(list: MutableList<Task>){
    print("\nDigite la ID:")
    val input = readLine()?.toIntOrNull() ?:0
    val task = list.find{it.id == input}
    
    if (task != null) {
        println("\n"+ "||".repeat(30)+ "\nID: ${task.id} \nTitulo: ${task.title}\nDescripcion: ${task.description}\nPrioridad: ${task.priority}\nEstado de la Tarea: ${if (task.state == true )"Completada" else "Incompleta"}\n " + "||".repeat(30))
    } else {println("\nERROR: ID Invalida\n")}
}

//Listar Tareas 
fun listTasks(list: MutableList<Task>){
    var listOn = true 
    //Primero imprime el Menu
    do{
        println("\n" + "=".repeat(30))
        println("-------Listar de la forma--------")
        println("1. Listar todos\n2. Listar por Titulo \n3. Listar por Id \n4. Listar Tareas incompletas\n5. Listar Tareas completadas\n6. Listar por Prioridad(Solo se mostraran las Tareas Incompletas)\n7. Volver al Menu principal\n")
        print("Digite su opcion: ")
        //Input si no se puede convertir a Int da null y por defecto da valor 0
        val input = readLine()?.toIntOrNull() ?: 0
        when (input){
            1 -> printTasks(sortedList(list,1))
            2 -> printTasks(sortedList(list,2))
            3 -> printTasks(sortedList(list,3))
            4 -> printTasks(sortedList(list,4))
            5 -> printTasks(sortedList(list,5))
            6 -> printTasks(sortedList(list,6))
            7 -> listOn = false
            else -> println("\nERROR: Digite el Literal/Numero de la opcion correspondiente\n")
        }
    } while (listOn)
}
//Imprime la Lista correspondiente
fun printTasks(list: MutableList<Task>){
    var num = 1
    if (list.isEmpty()) println("\n" +  "||".repeat(30)+ "\nLista vacia")
  for (i in list){
    println("\n" +  "||".repeat(30))
    println("Tarea N°$num")
    num++
    val state = if (i.state == true) "Completa" else "Incompleta"
    println("ID: ${i.id} \nTitulo: ${i.title}\nDescripcion: ${i.description}\nPrioridad: ${i.priority}\nEstado de la Tarea: $state ")
    }
    println("||".repeat(30))
}

//Organiza dependiendo la eleccion del Usuario
fun sortedList(list: MutableList<Task>, option: Int): MutableList<Task>{
    val orderPriority = mapOf("Alta" to 1, "Media" to 2, "Baja" to 3)
    return  when (option){
        1 -> list.shuffled().toMutableList()
        2 -> list.sortedBy{it.title}.toMutableList()
        3 -> list.sortedBy{it.id}.toMutableList()
        4 -> list.filter{it.state == false}.toMutableList()
        5 -> list.filter{it.state == true}.toMutableList()
        6 -> list.filter{it.state == false}.sortedBy{orderPriority[it.priority]}.toMutableList()
        else -> list
    }
    
}
//Añadir Tareas
fun addTask(list: MutableList<Task>){
    println("\n-------------Tarea------------")
    //Para el input se llama a la funcion de input... para que el usuario noingrese texto en blanco.    
    val title = inputNotBlankOrNull("Titulo de la tarea")
    val description = inputNotBlankOrNull("Descripcion de la Tarea")
    var priority = ""
    while (priority.isBlank()){
        println("Prioridad: \n1. Alta\n2. Media \n3. Baja\n")
        val input = readLine()?.toIntOrNull() ?: 0
        when (input) {
            1 -> priority = "Alta" 
            2 -> priority = "Media" 
            3 -> priority = "Baja" 
            else -> println( "Error: Digite el Literal/Numero de la opcion correspondiente\n" )
        }
    }
    var id = 1
    list.forEach{it -> id++}
    val newTask = Task(id,title,description,priority,false)
    
    list.add(newTask)
    save(newTask)
    
    
}

//Input especial para ingreso de datos para la tarea 
//Recibe como parametro un String y retorna un String
fun inputNotBlankOrNull(promt:String): String {
    while(true){
        println(promt)//Imprime el mensaje recibito por parametro
        val input = readLine() //Lee
        //Verifica que input no este vacio.
        if (!input.isNullOrBlank()){ 
            return input //Si no esta vacio retorna el input
        } else {
        // Sino imprime Error y continue el bucle
            println("Error: No puede estar en blanco, intente de nuevo")
        }
    }
}
