
import data.TaskRepository
import domain.Task
import domain.Priority
import presentation.navigation.AppNavigation
import presentation.terminalview.TerminalView
import utils.Input
import presentation.viewmodel.TaskViewModel

fun main() {
    //Repositorio
    val dataTasks = TaskRepository()
    val input = Input()

    //Cuandon se trate de editar o agreagar Tareas, esto lo controlara viewModel.
    val taskViewModel = TaskViewModel(dataTasks,input)
    //Pantallas o Impresiones
    val view = TerminalView(taskViewModel)

    //Este es el que se comunica con todos los demas objetos.
    AppNavigation(view,input)
}
