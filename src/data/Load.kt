package data

import java.io.File
import java.io.IOException


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
