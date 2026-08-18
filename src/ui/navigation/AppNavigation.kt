package ui.navigation

import ui.TerminalView
import ui.TerminalInput

fun AppNavigation(){
    val menuView = TerminalView()
    Screen.MAIN_MENU.menu(menuView,1)
    val option  = TerminalInput()::inputNumbers
    
    do{
        when(option()) {
            1 -> 
        }
    }
}

enum class Screen(val menu: (TerminalView, Int) -> Unit ){ 
    MAIN_MENU(TerminalView::showMenu)
}
