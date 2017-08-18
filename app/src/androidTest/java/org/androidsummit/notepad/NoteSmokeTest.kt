package org.androidsummit.notepad

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.androidsummit.notepad.data.Note
import org.androidsummit.notepad.data.NoteDatabase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteSmokeTest {

    private lateinit var db: NoteDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java).build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun smokeTest() {
        val note = Note().apply {
            text = "Foo Bar"
        }
        db.noteDao().insert(note)
        db.noteDao().getAll().subscribe {
            all ->
            assertEquals(1, all.size)
            assertEquals("Foo Bar", all.first().text)
        }
    }
}