package org.androidsummit.notepad.data

import android.arch.persistence.room.Room
import android.content.Context

object DataStore {

    lateinit var notes: NoteDatabase
        private set

    fun init(context: Context) {
        notes = Room.databaseBuilder(context, NoteDatabase::class.java, "notes").build()
    }

}