package org.androidsummit.notepad

import android.app.Application
import org.androidsummit.notepad.data.DataStore

class NotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DataStore.init(this)
    }
}