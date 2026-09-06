package ui.navigation

import ui.TerminalView
import utils.Input

fun AppNavigation(){
    val terminal = TerminalView()

    terminal.showMainMenu()

    val d = Input()

    d.inputNumbers()
}

