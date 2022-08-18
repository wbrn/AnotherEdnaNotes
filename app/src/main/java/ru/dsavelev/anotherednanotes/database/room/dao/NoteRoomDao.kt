package ru.dsavelev.anotherednanotes.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.dsavelev.anotherednanotes.model.Note

@Dao
interface NoteRoomDao {
    @Query("SELECT * FROM notes_table")
    fun  getAllNotes(): LiveData<List<Note>>

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}