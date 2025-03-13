package com.example.noteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NotesAdapter(
    private val list: MutableList<Note>
): RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
        ): NoteViewHolder {
        return NoteViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note,
                parent, false,
            )
        )

    }

    override fun getItemCount(

    ): Int = list.size  //total number of notes

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = list[position]  // Get the note at the current position
        holder.bind(note)
    }

    fun addNote(note: Note) {
        list.add(note)
        notifyItemInserted(list.size - 1)
    }

}
