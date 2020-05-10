package com.example.application


import java.util.*
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.apllication.R

data class Note(val id: Int, val text: String, val deadline: Date, val drawableRes: Int)


object NoteContract {

    const val TABLE_NAME = "my notes"

    object NoteEntry: Columns {
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
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,
        "${NoteEntry.DATE} INTEGER NOT NULL,








package com.example.application


import java.util.*
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.apllication.R

data class Note(val id: Int, val text: String, val deadline: Date, val drawableRes: Int)


object NoteContract {

    const val TABLE_NAME = "my notes"

    object NoteEntry: Columns {
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
        db?.execSQL(SQL_NOTES_CREATE)
        }
    }

}
        }
    }

}