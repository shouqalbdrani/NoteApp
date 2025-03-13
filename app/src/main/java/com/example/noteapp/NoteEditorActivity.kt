package com.example.noteapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.activity.ComponentActivity
import android.content.Intent

class NoteEditorActivity : ComponentActivity() {

    private lateinit var noteTitleEditText: EditText
    private lateinit var noteContentEditText: EditText
    private lateinit var characterCountTextView: TextView
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the correct layout for this activity
        setContentView(R.layout.activity_note_editor)

        noteTitleEditText = findViewById(R.id.noteTitleEditText)
        noteContentEditText = findViewById(R.id.noteContentEditText)
        characterCountTextView = findViewById(R.id.characterCountTextView)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)

        characterCountTextView.text = "Character count: 0"

        // add TextWatcher to EditText to update the character count 

        noteContentEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                val charCount = editable?.length ?: 0
                characterCountTextView.text = "Character count: $charCount"
            }
        })

        // check if the save button clicked that both title and content are filled
        saveButton.setOnClickListener {
            val noteTitle = noteTitleEditText.text.toString().trim()
            val noteContent = noteContentEditText.text.toString().trim()

            if (noteTitle.isEmpty() || noteContent.isEmpty()) {
                Toast.makeText(this, "Both Title and Content are required", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = Intent().apply {
                    putExtra("title", noteTitle)
                    putExtra("content", noteContent)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}
