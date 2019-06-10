package com.lopukh.taskapp.screens.table

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lopukh.taskapp.POJO.Note

class TableRetainedFragment : Fragment() {

    private var notes: ArrayList<Note>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun notes(notes: ArrayList<Note>) {
        this.notes = notes
    }

    fun notes(): ArrayList<Note>? {
        return notes
    }
}