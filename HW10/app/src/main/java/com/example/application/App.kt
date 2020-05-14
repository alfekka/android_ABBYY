package com.example.application

import android.app.Application
import com.example.application.data.AppSqliteOpenHelper
import com.example.application.data.NoteRepository

class App: Application() {
    companion object {
        lateinit var noteRepository: NoteRepository
    }
    override fun onCreate() {
        super.onCreate()
        val helper = AppSqliteOpenHelper(this)
        noteRepository = NoteRepository(helper)
    }
}