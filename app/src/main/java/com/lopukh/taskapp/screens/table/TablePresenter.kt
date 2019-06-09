package com.lopukh.taskapp.screens.table

import com.lopukh.taskapp.POJO.Note

class TablePresenter(private val view: TableView) {

    private lateinit var notes: ArrayList<Note>

    fun getNotes(){
        view.showDate(notes)
    }

    fun initNotes(){
        notes = ArrayList()
        for (i in 1..100){
            notes.add(Note(i.toString()))
        }
    }

    fun addNote(){
        val lastNoteTitle = if (notes.isNotEmpty()){
            notes[notes.lastIndex].title.toInt()
        }else
            0
        val newNote = Note((lastNoteTitle+1).toString())
        notes.add(newNote)
        view.showDate(notes)
    }

    fun removeNote(position: Int){
        notes.removeAt(position)
        view.onItemRemoved(position)
    }

    fun getListNotes(): ArrayList<Note>{
        return notes
    }

    fun setListNotes(notes: ArrayList<Note>?){
        if (notes == null)
            initNotes()
        else
            this.notes = notes
    }

}