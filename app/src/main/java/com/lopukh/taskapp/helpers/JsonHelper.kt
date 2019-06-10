package com.lopukh.taskapp.helpers

import android.content.Context
import com.google.gson.Gson
import com.lopukh.taskapp.POJO.Note
import com.lopukh.taskapp.POJO.NoteList
import java.io.BufferedReader
import java.io.File

class JsonHelper(val context: Context) {

    private val DB_NAME = "notes.json"

    fun read(): ArrayList<Note>{
        return try{
            val path = context.filesDir
            val file = File(path, DB_NAME)
            val bufferedReader: BufferedReader = file.bufferedReader()
            val notes = Gson().fromJson<ArrayList<Note>>(
                (bufferedReader.use { it.readText() }),
                NoteList::class.java)
            return notes
        }catch (e: Exception){
            ArrayList()
        }
    }

    fun write(notes: ArrayList<Note>): Boolean{
        return try {
            val json = Gson().toJson(notes)
            val path = context.filesDir
            val file = File(path, DB_NAME)
            file.createNewFile()
            file.writeText(json)
            true
        }catch (e: Exception){
            false
        }
    }
}