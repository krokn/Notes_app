package com.example.notes_app_mvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
fun StartScreen (navController: NavHostController){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "What you will use?",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = {
                navController.navigate(route = NavRoute.Main.route)
            },
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
            ) {
                Text(text = "Room database")
            }
            Button(onClick = {
                navController.navigate(route = NavRoute.Main.route)
            },
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
            ) {
            Text(text = "Firebase database")
        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    Notes_app_MVVMTheme() {
        StartScreen(navController = rememberNavController())
    }
}