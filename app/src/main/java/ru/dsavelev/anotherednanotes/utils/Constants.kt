package ru.dsavelev.anotherednanotes.utils

import ru.dsavelev.anotherednanotes.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"


lateinit var REPOSITORY: DatabaseRepository



object Constants {
    object Keys{
        const val NOTES_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "notes_table"
        const val NOTE_TITLE = "notes_title"
        const val NOTE_SUBTITLE = "notes_subtitle"
        const val ADD_NOTE = "Add note"
        const val ADD_ICON = "Add Icon"
        const val TITLE = "Title"
        const val SUBTITLE = "Subitle"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val ID = "Id"
        const val NONE = "none"
        const val UPDATE = "Update"
        const val DELETE = "Delete"
        const val NAV_BACK = "BACK"
        const val EDIT_NOTE = "Edit Note"
        const val EMPTY = ""
        const val UPDATE_NOTE = "Update Note"




    }

    object Screens{
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"

    }
}