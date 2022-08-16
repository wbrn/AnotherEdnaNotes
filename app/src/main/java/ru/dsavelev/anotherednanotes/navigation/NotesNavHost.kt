package ru.dsavelev.anotherednanotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.dsavelev.anotherednanotes.screens.Add
import ru.dsavelev.anotherednanotes.screens.Main
import ru.dsavelev.anotherednanotes.screens.Note
import ru.dsavelev.anotherednanotes.screens.Start

sealed class NavRoute(val route: String) {
    object Start: NavRoute("start_screen")
    object Main:  NavRoute("main_screen")
    object Add:   NavRoute("add_screen")
    object Note:  NavRoute("note_screen")
}



@Composable
fun NotesNavHost() {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){ Start(navController = navController) }
        composable(NavRoute.Main.route) { Main(navController = navController) }
        composable(NavRoute.Note.route) { Note(navController = navController) }
        composable(NavRoute.Add.route)  { Add(navController = navController) }
    }

}