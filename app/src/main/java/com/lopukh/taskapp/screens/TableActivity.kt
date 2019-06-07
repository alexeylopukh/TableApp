package com.lopukh.taskapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lopukh.taskapp.POJO.Note
import com.lopukh.taskapp.adapters.ListAdapter
import com.lopukh.taskapp.R

class TableActivity : AppCompatActivity(), TableView {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListAdapter
    lateinit var presenter: TablePresenter

    override fun showDate(notes: ArrayList<Note>) {
        adapter.notes(notes)
        recyclerView.smoothScrollToPosition(adapter.itemCount)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        presenter = TablePresenter(this)
        recyclerView = findViewById(R.id.table_view)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = linearLayoutManager
        adapter = ListAdapter()
        adapter.notes(ArrayList())
        recyclerView.adapter = adapter
        adapter.notes()
        presenter.loadNotes()
    }

    fun onClickAddNote(view: View){
        presenter.addNote()
    }
}
