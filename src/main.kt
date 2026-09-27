
import data.TaskRepository
import domain.Task
import domain.Priority
import presentation.navigation.AppNavigation
import presentation.terminalview.TerminalView
import utils.Input
import utils.ParserPrint
import presentation.viewmodel.TaskViewModel


fun main() {
    //Limpia la pantalla al iniciar el app.
    ProcessBuilder("clear").inheritIO().start().waitFor()
    //Repositorio
    val dataTasks = TaskRepository()
    val input = Input()

    //Moldes para imprimir Tareas
    val parse = ParserPrint()

    //Cuandon se trate de editar o agreagar Tareas, esto lo controlara viewModel.
    val taskViewModel = TaskViewModel(dataTasks,input,parse)
    //Pantallas o Impresiones
    val view = TerminalView(taskViewModel)

    //Este es el que se comunica con todos los demas objetos.
    AppNavigation(view,input)
}
