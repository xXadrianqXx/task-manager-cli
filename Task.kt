data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: String,
    val state: Boolean = false
)

fun main(){
    var onApp = true
    val listOfTasks: MutableList<Task> = mutableListOf()
    do{
        println("\n------------Menu-------------")
        println("1. Agregar Tarea\n2. Listar Tareas\n3. Buscar Tarea\n4. Salir\n")
        print("Digite su opcion: ")
        val input = readLine()?.toIntOrNull() ?: 0
        when (input){
            1 -> addTask(listOfTasks)
            2 -> listTasks(listOfTasks)
            3 -> findTask(listOfTasks)
            4 -> onApp = false
            else -> println("\nERROR: Digite el Literal/Numero de la opcion correspondiente\n")
        }
    } while(onApp)
}

//Buscar Tarea *Se podria agregar configuraciones de busqueda*
fun findTask(list: MutableList<Task>){
    var findOn = true
    do{    
        println("\n" + "=".repeat(30))
        println("---------Buscar Tarea-----------")
        println("1. Buscar por ID\n2. Buscar por Titulo\n3. Volver al Menu Principal")
        print("\nDigite su opcion: ")
        val input = readLine()?.toIntOrNull() ?: 0
        when (input){
            1 -> searchForId(list)
            2 -> searchForTitle(list)
            3 -> findOn = false
            else -> println("\nERROR: Digite el Literal/Numero de la opcion  correspondiente\n")
        }
    }while(findOn)
     
}

fun searchForTitle(list: MutableList<Task>){
    print("\nDigite el titulo de la Tarea: ")
    val input = readLine() ?: ""
    val results = list.filter{it.title.contains(input, ignoreCase = true)}.toMutableList()
    if (!results.isEmpty()){
        println("\n" + "=".repeat(30))
        println("Resultado/s")
        printTasks(results)
        
    } else { println("\nNo se encontraron Resultados\n")}
}


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
    do{
        println("\n" + "=".repeat(30))
        println("-------Listar de la forma--------")
        println("1. Listar todos\n2. Listar por Titulo \n3. Listar por Id \n4. Listar Tareas incompletas\n5. Listar Tareas completadas\n6. Listar por Prioridad(Solo se mostraran las Tareas Incompletas)\n7. Volver al Menu principal\n")
        print("Digite su opcion: ")
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
    val title = inputNotBlankOrNull("Titulo de la tarea")
    val description = inputNotBlankOrNull("Descripcion de la Tarea")
    var priority = ""
    while (priority.isBlank()){
        println("Prioridad \n1. Alta\n2. Media \n3. Baja")
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
    
}

//Input especial para ingreso de datos para la tarea 

fun inputNotBlankOrNull(promt:String): String {
    while(true){
        println(promt)
        val input = readLine()
        if (!input.isNullOrBlank()){
            return input
        } else {
            println("Error: No puede estar en blanco, intente de nuevo")
        }
    }
}
