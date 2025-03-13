package com.example.noteapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.adapter.NotesAdapter
import com.example.noteapp.model.Note

class MainActivity : ComponentActivity() {


    private lateinit var notesAdapter: NotesAdapter
    private val notesList = mutableListOf(
        Note.Example1,
        Note.Example2,
        Note.Example3,
        Note.Example4,
        Note.Example5,
        Note.Example6
    )

    private val noteEditorLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                if (data != null) {
                    val newTitle = data.getStringExtra("title") ?: ""
                    val newContent = data.getStringExtra("content") ?: ""

                    if (newTitle.isNotEmpty() && newContent.isNotEmpty()) {
                        val newNote = Note(newTitle, newContent)
                        notesAdapter.addNote(newNote)
                    } else {
                        Toast.makeText(this, "Failed to add note. Data missing!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: RecyclerView = findViewById(R.id.list)
        notesAdapter = NotesAdapter(notesList)

        list.adapter = notesAdapter
        list.layoutManager = LinearLayoutManager(this)

        val buttonNewNote: Button = findViewById(R.id.buttonNewNote)
        buttonNewNote.setOnClickListener {
            val intent = Intent(this, NoteEditorActivity::class.java)
            noteEditorLauncher.launch(intent)
        }
    }
}
