package presentation.navigation

import presentation.terminalview.TerminalView
import utils.Input

fun AppNavigation(view: TerminalView, input: Input){
    var onApp = true
    do{
        val option = input.inputNumbers()
        val action = view.currentList[option]

        if (action == null) {
            println("La opción digitada no existe.")
        }else {onApp = action.invoke()}
        
    } while(onApp)
}

