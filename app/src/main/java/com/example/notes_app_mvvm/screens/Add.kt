package com.example.notes_app_mvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes_app_mvvm.navigation.NavRoute
import com.example.notes_app_mvvm.ui.theme.Notes_app_MVVMTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen (navController: NavHostController){
    var title by remember { mutableStateOf("")}
    var subtitle by remember { mutableStateOf("")}

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add new note",
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it},
                label = { Text(text = "Note title")
                }
            )
            OutlinedTextField(
                value = subtitle,
                onValueChange = { subtitle = it},
                label = { Text(text = "Note subtitle") }
            )
            Button(
                onClick = { navController.navigate(NavRoute.Main.route) },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(150.dp)
            ) {
                Text(text = "Add Note")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen(){
    Notes_app_MVVMTheme() {
        AddScreen(navController = rememberNavController())
    }
}