package com.lopukh.taskapp.screens.table

import com.lopukh.taskapp.POJO.Note

interface TableView {
    fun showDate(notes: ArrayList<Note>)
    fun onItemRemoved(position: Int)

}