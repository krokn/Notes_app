package com.example.notes_app_mvvm.ui.theme

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes_app_mvvm.model.Note
import com.example.notes_app_mvvm.utils.TYPE_FIREBASE
import com.example.notes_app_mvvm.utils.TYPE_ROOM

class MainViewModel (application: Application) : AndroidViewModel(application){

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }


    init {
        readTest.value =
            when(dbType.value) {
                TYPE_ROOM -> listOf<Note>(
                    Note(title = "Note 1", subtitle = "Subtitle_1"),
                    Note(title = "Note 2", subtitle = "Subtitle_2"),
                    Note(title = "Note 3", subtitle = "Subtitle_3"),
                    Note(title = "Note 4", subtitle = "Subtitle_4")
                )
                TYPE_FIREBASE -> listOf()
                else -> emptyList()
            }

    }

    fun initDatabase(type:String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDataBase $type")
    }
}

class MainViewModelFactory (private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T

        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}