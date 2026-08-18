package ui.navigation

import ui.TerminalView
import ui.TerminalInput

fun AppNavigation(){
    val menuView = TerminalView()
    //Screen.MAIN_MENU.menu(menuView,1)
    val option  = TerminalInput()::inputNumbers
    var onApp = true
    var showText: () -> Unit
    
    do{
        showText()
        showText = {Screen.MAIN_MENU.menu(menuView,option())}
        when(option()) {
            1 -> Screen.MAIN_MENU.menu(menuView,1)
            2 -> onApp = false
            else -> Screen.MAIN_MENU.menu(menuView,1)
        }
    }while(onApp)
}

enum class Screen(val menu: (TerminalView, Int) -> Unit ){ 
    MAIN_MENU(TerminalView::showMenu)
}
