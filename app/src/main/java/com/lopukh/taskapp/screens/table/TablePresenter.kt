package com.lopukh.taskapp.screens.table

import com.lopukh.taskapp.POJO.Note
import com.lopukh.taskapp.helpers.JsonHelper

class TablePresenter(private val view: TableView) {

    private lateinit var notes: ArrayList<Note>
    lateinit var database: JsonHelper


    fun getNotes() {
        view.showDate(notes)
    }

    fun initNotes() {
        notes = database.read()
        if (notes.isNullOrEmpty()) {
            for (i in 1..100) {
                notes.add(Note(i.toString()))
            }
            database.write(notes)
        }
    }

    fun addNote() {
        val lastNoteTitle = if (notes.isNotEmpty()) {
            notes[notes.lastIndex].title.toInt()
        } else
            0
        val newNote = Note((lastNoteTitle + 1).toString())
        notes.add(newNote)
        view.showDate(notes)
        database.write(notes)
    }

    fun removeNote(position: Int) {
        val delNote = notes[position]
        notes.remove(delNote)
        view.onItemRemoved(position)
        database.write(notes)
    }

    fun getListNotes(): ArrayList<Note> {
        return notes
    }

    fun setListNotes(notes: ArrayList<Note>?) {
        if (notes == null) //Было открытие приложение
            initNotes()
        else
            this.notes = notes //Была перезагрузка экрана
    }

}