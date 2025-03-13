package com.example.noteapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NoteViewHolder(view: View,
    ): RecyclerView.ViewHolder(view) {
    private val noteTitle: TextView = view.findViewById(R.id.noteTitle)
    private val noteContentPreview: TextView = view.findViewById(R.id.noteContentPreview)

    fun bind(
        note: Note
    ) {
        noteTitle.text = note.title
        noteContentPreview.text = note.content.take(500)
    }
}
