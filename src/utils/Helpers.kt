package utils

class Input{

    fun inputNumbers(): Int {
        do{
            print("\nDigite su opción: ")
            try{
                val input = readln()
                if (!input.isNullOrBlank())return input.toInt()
            } catch(e: NumberFormatException){
                println("Error: $e")
                println("Digite el indice númerico de la opción requerida.")
            } catch (e: Exception) {
                println(e)
            }
        } while(true)
    }
}
