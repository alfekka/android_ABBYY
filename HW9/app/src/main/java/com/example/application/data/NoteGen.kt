package com.example.application.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.application.R

object NoteGen {

    const val TABLE_NAME = "note"

    object NoteEntry: BaseColumns {
        const val TEXT = "text"
        const val DEADLINE = "do until"
        const val IMAGE_ID = "image_id"
    }

    private const val SQL_NOTES_CREATE =
        "CREATE TABLE $TABLE_NAME (" +
                "${Columns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${NoteEntry.TEXT} TEXT NOT NULL," +
                "${NoteEntry.DATE} INTEGER NOT NULL," +
                "${NoteEntry.IMAGE_ID} INTEGER NOT NULL)"


    fun createTable(db: SQLiteDatabase?) {
        if (db === null) {
            return
        }
        db.execSQL(SQL_CREATE_TABLE)
        NOTE_LIST.forEach {
            val values = ContentValues()
            values.put(NoteEntry.TEXT, it.first)
            values.put(NoteEntry.DEADLINE, it.second)
            values.put(NoteEntry.IMAGE_ID, it.third)
            db.insert(TABLE_NAME, null, values)
        }
    }

}