package org.androidsummit.notepad.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.item_note.view.*
import org.androidsummit.notepad.R
import org.androidsummit.notepad.data.DataStore
import org.androidsummit.notepad.data.Note
import org.androidsummit.notepad.util.android
import org.androidsummit.notepad.util.layoutInflater

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private var sub: Disposable? = null
    private var notes: List<Note>? = null

    init {
        setHasStableIds(true)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        sub = DataStore.notes.noteDao().getAll()
                .android()
                .subscribe {
                    notes = it
                    notifyDataSetChanged()
                }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)
        sub?.dispose()
        sub = null
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.text.text = notes!![position].text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(parent.layoutInflater.inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
    }
}