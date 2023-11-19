package com.example.notes_app_mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes_app_mvvm.database.room.AppRoomDatabase
import com.example.notes_app_mvvm.database.room.repository.RoomRepository
import com.example.notes_app_mvvm.model.Note
import com.example.notes_app_mvvm.utils.REPOSITORY
import com.example.notes_app_mvvm.utils.TYPE_FIREBASE
import com.example.notes_app_mvvm.utils.TYPE_ROOM

class MainViewModel (application: Application) : AndroidViewModel(application){
    val context = application
    fun initDatabase(type:String, onSuccess: () -> Unit) {
        Log.d("checkData", "MainViewModel initDataBase $type")
        when(type) {
            TYPE_ROOM -> {
                val  dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
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