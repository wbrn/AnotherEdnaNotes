package ru.dsavelev.anotherednanotes.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.dsavelev.anotherednanotes.model.Note
import ru.dsavelev.anotherednanotes.navigation.NavRoute
import ru.dsavelev.anotherednanotes.ui.theme.MainViewModel
import ru.dsavelev.anotherednanotes.ui.theme.MainViewModelFactory
import ru.dsavelev.anotherednanotes.utils.Constants
import ru.dsavelev.anotherednanotes.utils.DB_TYPE
import ru.dsavelev.anotherednanotes.utils.TYPE_FIREBASE
import ru.dsavelev.anotherednanotes.utils.TYPE_ROOM

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavRoute.Add.route)
            }) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = Constants.Keys.ADD_ICON,
                tint = Color.White
            )
        }

    }) {
//        Column() {
//            NoteItem(title = "Note 1", "Subtitle for Note 1", navController = navController)
//            NoteItem(title = "Note 2", "Subtitle for Note 2", navController = navController)
//            NoteItem(title = "Note 3", "Subtitle for Note 3", navController = navController)
//            NoteItem(title = "Note 4", "Subtitle for Note 4", navController = navController)
//        }
        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note, navController = navController)

            }
        }

    }
}
@Composable
    fun NoteItem(note: Note, navController: NavController){
        val noteId = when(DB_TYPE) {
            TYPE_FIREBASE -> note.firebaseId
            TYPE_ROOM -> note.id
            else -> Constants.Keys.EMPTY
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route + "/${noteId}")
            },
            elevation = 6.dp
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = note.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = note.subtitle)
            }

        }
    }
