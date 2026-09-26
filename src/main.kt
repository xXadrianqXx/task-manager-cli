
import data.TaskRepository
import domain.Task
import domain.Priority
import presentation.navigation.AppNavigation
import presentation.terminalview.TerminalView
import utils.Input

fun main() {
    //val dataTasks = TaskRepository()
    val view = TerminalView()
    val input = Input() 
    AppNavigation(view,input)
}
