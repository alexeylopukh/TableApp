package com.lopukh.taskapp.screens

import com.lopukh.taskapp.POJO.Note

class TablePresenter(private val view: TableView) {

    lateinit var notes: ArrayList<Note>

    fun loadDate(){
        notes = ArrayList<Note>()
        if (isBaseEmpty()){
            notes = firstRun()
        }
        view.showDate(notes)
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