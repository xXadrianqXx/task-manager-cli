package data

import java.io.File

//Borramos el txt.
fun deleteFile(){
    val file = File("TareasGuardadas.txt")
    //Comprobamos que existe por siacaso.
    if (file.exists()){
        file.delete()
    }
}
