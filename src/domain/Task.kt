package domain

//Llevan var para poder modificar las Tareas, unico que no se puede cambiar es la id.
data class Task (
    val id: Int,
    var title: String,
    var description: String,
    var priority: Priority,
    var state: Boolean = false
)

//Clase de prioridad para que se pueda cambiar facilmente
enum class Priority {
    ALTA,MEDIA,BAJA
}
