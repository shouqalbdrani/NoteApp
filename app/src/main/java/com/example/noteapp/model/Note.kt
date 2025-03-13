package com.example.noteapp.model

data class Note(
    val title: String,
    val content: String
){
    companion object{
        val Example1 = Note(
            title = "Shopping List",
            content = "Buy eggs, milk, and bread."
        )
        val Example2 = Note(
            title = "Meeting Notes",
            content = "Discuss project progress and next steps."
        )
        val Example3 = Note(
            title = "Vacation Ideas",
            content = "Explore Paris, Rome, and Barcelona."
        )
        val Example4 = Note(
            title = "Workout Routine",
            content = "1. Warm-up\n2. Cardio\n3. Strength training"
        )
        val Example5 = Note(
            title = "Book Recommendations",
            content = "The Great Gatsby, 1984, To Kill a Mockingbird."
        )
        val Example6 = Note(
            title = "Coding Practice",
            content = "Focus on data structures and algorithms this week."
        )
    }
}
