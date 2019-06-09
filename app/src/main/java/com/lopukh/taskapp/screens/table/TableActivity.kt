package com.lopukh.taskapp.screens.table

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lopukh.taskapp.POJO.Note
import com.lopukh.taskapp.R
import com.lopukh.taskapp.adapters.ListAdapter





class TableActivity : AppCompatActivity(), TableView {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter
    private lateinit var presenter: TablePresenter
    private var retainedFragment: TableRetainedFragment? = null

    override fun showDate(notes: ArrayList<Note>) {
        adapter.notes(notes)
        recyclerView.smoothScrollToPosition(adapter.itemCount)
    }

    override fun onItemRemoved(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        presenter = TablePresenter(this)
        recyclerView = findViewById(R.id.table_view)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
        linearLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = linearLayoutManager
        adapter = ListAdapter()
        adapter.notes(ArrayList())
        recyclerView.adapter = adapter
        val fm = supportFragmentManager
        retainedFragment = fm.findFragmentByTag("notes") as TableRetainedFragment?
        if (retainedFragment == null){ //Первый запуск приложения
            retainedFragment = TableRetainedFragment()
            fm.beginTransaction().add(retainedFragment!!, "notes").commit()
        }
        presenter.setListNotes(retainedFragment!!.notes())
        presenter.getNotes()


        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("not implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                presenter.removeNote(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(recyclerView)
    }

    fun onClickAddNote(view: View){
        presenter.addNote()
    }

    override fun onDestroy() {
        super.onDestroy()
        retainedFragment!!.notes(presenter.getListNotes())
    }
}
