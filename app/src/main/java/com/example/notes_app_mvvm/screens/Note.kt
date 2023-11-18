package com.example.notes_app_mvvm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes_app_mvvm.ui.theme.Notes_app_MVVMTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteScreen (navController: NavHostController){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Title",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 25.dp)
                )
                Text(
                    text = "Subtitle",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }

    }
}

@Preview(showBackground = true)
@Composable
fun prevNoteScreen(){
    Notes_app_MVVMTheme() {
        NoteScreen(navController = rememberNavController())
    }
}