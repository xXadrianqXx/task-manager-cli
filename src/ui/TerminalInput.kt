package ui

class TerminalInput{

    fun inputNumbers(): Int {
        do{
            try{
                val input = readln()
                if (!input.isNullOrBlank())return input.toInt()
            } catch(e: NumberFormatException){
                println("Error: $e")
                println("Digite el indice númerico de la opción requerida.")
            } catch (e: Exception) {
                println(e)
            }
            print("\nDigite su opción: ")
        } while(true)
    }
}
