package com.lopukh.taskapp.screens

import com.lopukh.taskapp.POJO.Note

interface TableView {
    fun showDate(notes: ArrayList<Note>)
}