package com.lopukh.taskapp.screens.table

import com.lopukh.taskapp.POJO.Note

class TablePresenter(private val view: TableView) {

    lateinit var notes: ArrayList<Note>

    fun loadNotes(){
        notes = ArrayList<Note>()
        if (isBaseEmpty()){
            notes = firstRun()
        }
        view.showDate(notes)
    }

    fun addNote(){
        val lastNoteNumber = notes.lastIndex
        val lastNoteTitle = notes[notes.lastIndex].title
        val newNote = Note((lastNoteTitle.toInt()+1).toString())
        notes.add(newNote)
        view.showDate(notes)
    }

    fun removeNote(position: Int){
        notes.removeAt(position)
        view.onItemRemoved(position)
    }

    fun isBaseEmpty(): Boolean{
        return true
    }

    fun firstRun():ArrayList<Note>{
        val notes = ArrayList<Note>()
        for (i in 1..100){
            notes.add(Note(i.toString()))
        }
        return notes
    }
}