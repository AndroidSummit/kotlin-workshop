package org.androidsummit.notepad.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface NoteDao {

    @Query("select * from note order by created_at asc")
    fun getAll(): List<Note>

}