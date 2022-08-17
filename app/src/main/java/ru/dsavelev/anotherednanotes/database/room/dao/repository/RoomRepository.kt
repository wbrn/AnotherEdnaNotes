package ru.dsavelev.anotherednanotes.database.room.dao.repository

import androidx.lifecycle.LiveData
import ru.dsavelev.anotherednanotes.database.DatabaseRepository
import ru.dsavelev.anotherednanotes.database.room.dao.NoteRoomDao
import ru.dsavelev.anotherednanotes.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DatabaseRepository{
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