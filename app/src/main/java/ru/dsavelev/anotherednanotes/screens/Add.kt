package ru.dsavelev.anotherednanotes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.dsavelev.anotherednanotes.model.Note
import ru.dsavelev.anotherednanotes.navigation.NavRoute
import ru.dsavelev.anotherednanotes.ui.theme.MainViewModel

@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("")}
    var subtitle by remember { mutableStateOf("")}
    var isButtonEnabled by remember { mutableStateOf(false)}

    Scaffold() {
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add new note",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                                },
                label = { Text(text = "Note title")},
                isError = title.isEmpty()
            )
            OutlinedTextField(
                value = subtitle,
                onValueChange = {
                    subtitle = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                                },
                label = { Text(text = "Note subtitle")},
                isError = subtitle.isEmpty()

            )
            
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(note = Note(title = title, subtitle = subtitle)){
                        navController.navigate(NavRoute.Main.route)
                    }

                })
            {
                Text(text = "Add note")
            }
        }
        
    }

}