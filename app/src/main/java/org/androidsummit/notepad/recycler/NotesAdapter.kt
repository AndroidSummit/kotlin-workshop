package org.androidsummit.notepad.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers.io
import kotlinx.android.synthetic.main.item_note.view.*
import org.androidsummit.notepad.R
import org.androidsummit.notepad.data.DataStore
import org.androidsummit.notepad.data.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private var sub: Disposable? = null
    private var notes: List<Note>? = null

    init {
        setHasStableIds(true)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
        sub = DataStore.notes.noteDao().getAll()
                .observeOn(mainThread())
                .subscribeOn(io())
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

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_note, parent, false))
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
    }
}