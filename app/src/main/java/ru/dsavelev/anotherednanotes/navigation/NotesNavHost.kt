package ru.dsavelev.anotherednanotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.dsavelev.anotherednanotes.screens.*
import ru.dsavelev.anotherednanotes.ui.theme.MainViewModel
import ru.dsavelev.anotherednanotes.utils.Constants
import ru.dsavelev.anotherednanotes.utils.Constants.Screens.ADD_SCREEN
import ru.dsavelev.anotherednanotes.utils.Constants.Screens.MAIN_SCREEN
import ru.dsavelev.anotherednanotes.utils.Constants.Screens.NOTE_SCREEN
import ru.dsavelev.anotherednanotes.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val route: String) {
    object Start: NavRoute(START_SCREEN)
    object Main:  NavRoute(MAIN_SCREEN)
    object Add:   NavRoute(ADD_SCREEN)
    object Note:  NavRoute(NOTE_SCREEN)
}



@Composable
fun NotesNavHost(mViewModel: MainViewModel) {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){ StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStateEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteID = backStateEntry.arguments?.getString(Constants.Keys.ID))
        }
        composable(NavRoute.Add.route)  { AddScreen(navController = navController, viewModel = mViewModel) }
    }

}