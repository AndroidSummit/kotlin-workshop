package org.androidsummit.notepad

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_crud.*
import org.androidsummit.notepad.data.DataStore
import org.androidsummit.notepad.data.Note
import org.jetbrains.anko.doAsync

class CrudActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_accept, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_accept -> {
                save()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun save() {
        doAsync {
            DataStore.notes.noteDao().insert(Note().apply {
                text = edit_text.text.toString()
            })
        }
    }
}