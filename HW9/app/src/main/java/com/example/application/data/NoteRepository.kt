package com.example.application.data

import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import java.util.*
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.annotation.NonNull
import android.database.Cursor
import com.example.application.R
import java.lang.Long.getLong

class NoteRepository(private val helper: SQLiteOpenHelper) {

    companion object {
        private val NOTE_PROJECTION = arrayOf(
            BaseColumns._ID,
            NoteGen.NoteEntry.TEXT,
            NoteGen.NoteEntry.DEADLINE,
            NoteGen.NoteEntry.IMAGE_ID
        )
    }

    fun newNotes(): List<Note> {

        val db = helper.readableDatabase
        val sort = "${BaseColumns._ID} ASC"
        val cursor = db.query(NoteGen.TABLE_NAME, NOTE_PROJECTION, null, null,
            null, null, sort)

        val notes = mutableListOf<Note>()

        cursor.use {
            with(it) {
                while (moveToNext()) {
                    val id = getInt(getColumnIndex(BaseColumns._ID))
                    val text = getString(getColumnIndex(NoteGen.NoteEntry.TEXT))
                    val deadline = Date(getLong(getColumnIndex(NoteGen.NoteEntry.DEADLINE)))
                    val imageId = getInt(getColumnIndex(NoteGen.NoteEntry.IMAGE_ID))
                    notes.add(Note(id, text, deadline, imageId))
                }
            }
        }
        return notes
    }

    fun getNote(id: Int): Note? {
        val db = helper.readableDatabase
        val notes = mutableListOf<Note>()
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(id.toString())
        val cursor = db.query(NoteGen.TABLE_NAME,
            NOTE_PROJECTION,
            selection,
            selectionArgs,
            null,
            null,
            null)


        cursor.use {
            with(it) {
                if (moveToFirst()) {
                    val id = getInt(getColumnIndex(BaseColumns._ID))
                    val text = getString(getColumnIndex(NoteGen.NoteEntry.TEXT))
                    val deadline = Date(getLong(getColumnIndex(NoteGen.NoteEntry.DEADLINE)))
                    val imageId = getInt(getColumnIndex(NoteGen.NoteEntry.IMAGE_ID))
                    return Note(id, text, deadline, imageId)
                }
                return null
            }
        }
    }

}