import data.saveTask
import data.loadRepository
import domain.Task
import domain.Priority


fun main() {
    println("=== 📝 GUARDAR Y RECUPERAR ===\n")

    // 1️⃣ Crear y guardar tareas
    val tareas =  Task(1, "Aprender Kotlin", "Estudiar conceptos básicos", Priority.ALTA, false)
    saveTask(tareas)
        

    
    loadRepository()

}
