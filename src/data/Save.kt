package data 

import java.io.File
import java.io.IOException

fun save(task: String){
//try para que evite errores como por ejemplo que ya no hay espacio, o no tiene permisos para guardar
    try{
        //Definimos la ruta de guardado (Solo creamos donde se podria guardar, aun ni se crea el archivo)
        val file = File("TareasGuardadas.txt")
        //Guarda el parametro recibido
        file.appendText(task)
        println("La Tarea se Guardo Exitosamente!!")
    } catch(e:IOException){
    //Si es un problema de permisos o algo no da el error exacto.
        println("Error al Guardar: ${e.message}")
    } catch(e: Exception){
    //Nos da el error General, no especifica pero igual no dice que paso
        println("Error al Guardar: ${e.message}")
    }
    
}
