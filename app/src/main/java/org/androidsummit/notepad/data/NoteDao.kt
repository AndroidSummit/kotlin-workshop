package org.androidsummit.notepad.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface NoteDao {

    @Query("select * from note order by created_at asc")
    fun getAll(): Flowable<List<Note>>

    @Insert
    fun insert(vararg notes: Note)
}