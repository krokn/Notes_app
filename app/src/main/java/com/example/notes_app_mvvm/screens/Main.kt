package com.example.notes_app_mvvm.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes_app_mvvm.model.Note
import com.example.notes_app_mvvm.navigation.NavRoute
import com.example.notes_app_mvvm.MainViewModel
import com.example.notes_app_mvvm.MainViewModelFactory
import com.example.notes_app_mvvm.ui.theme.Notes_app_MVVMTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen (navController: NavHostController){

    val context = LocalContext.current
    val nViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                navController.navigate(NavRoute.Add.route)
                }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icons", tint = White)
            }
        }
    ) {
//        Column() {
////            NoteItem("Title1", "Subtitle1", navController = navController)
////            NoteItem("Title2", "Subtitle2", navController = navController)
////            NoteItem("Title3", "Subtitle3", navController = navController)
////            NoteItem("Title4", "Subtitle4", navController = navController)
//        }
//        LazyColumn(){
//            items(notes) { note ->
//                NoteItem(note = note, navController = navController)
//            }
//        }
    }
}
@Composable
fun NoteItem(note : Note, navController: NavController){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = note.title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = note.subtitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    Notes_app_MVVMTheme() {
        MainScreen(navController = rememberNavController())
    }
}