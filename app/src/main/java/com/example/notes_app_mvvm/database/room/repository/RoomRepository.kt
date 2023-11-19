package com.example.notes_app_mvvm.database.room.repository

import androidx.lifecycle.LiveData
import com.example.notes_app_mvvm.database.DatabaseRepository
import com.example.notes_app_mvvm.database.room.dao.NoteRoomDao
import com.example.notes_app_mvvm.model.Note

class RoomRepository (private val noteRoomDao: NoteRoomDao) : DatabaseRepository{
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }


}