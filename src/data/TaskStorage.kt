package data

import java.io.File
import java.io.IOException

fun save(tasks: String){
//try para que evite errores como por ejemplo que ya no hay espacio, o no tiene permisos para guardar
    try{
//Definimos la ruta de guardado (Solo creamos donde se podria guardar, aun ni se crea el archivo)
        val file = File("TareasGuardadas.txt")
    //Se reescribe todo el archivo.
        file.writeText(tasks)
        println("Los datos se actualizaron correctamente!\n")
        
        } catch(e:IOException){
            //Si es un problema de permisos o algo no da el error exacto.
            println("Error al Guardar: ${e.message}")
        } catch(e: Exception){
        //Nos da el error General, no especifica pero igual no dice que paso
            println("Error al Guardar: ${e.message}")
        }

}

fun load(): String? {

    val file = File("TareasGuardadas.txt")
//Verifica que el archivo exista, si no existe retorna null
    if (!file.exists()){
        println("No hay datos que cargar")
        return null
    }
//Nos aseguramos que en caso de que haya un error al leer file no diga que fue lo que paso si crashear.
    try { 
    // Si no hay error retorna todo el texto de file.
        val dataTask = file.readText()
        return dataTask
    } catch (e: IOException){
        println("Error al Intentar Cargar: ${e.message}")
    } catch (e: Exception){
        println("Error al Intentar Cargar: ${e.message}")
    }

    return null
    
}
