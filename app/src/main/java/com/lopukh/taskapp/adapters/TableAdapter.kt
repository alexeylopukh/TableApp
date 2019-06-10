package com.lopukh.taskapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lopukh.taskapp.POJO.Note
import com.lopukh.taskapp.R

class TableAdapter: RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    private lateinit var notes: ArrayList<Note>

    fun notes(): List<Note>{
        return notes
    }

    fun notes(notes: ArrayList<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberName.text = notes[position].title
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberName: TextView = itemView.findViewById(R.id.number_name)
    }
}