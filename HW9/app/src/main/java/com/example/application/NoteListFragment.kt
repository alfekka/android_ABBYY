package com.example.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class NoteListFragment : Fragment() {

    interface OpenNoteListener {
        fun openNote(id: Int)
    }

    var thread: Thread? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = NoteAdapter(emptyList()) {}
        threads = GlobalScope.launch(context = Dispatchers.Main) {
            val notes = NoteQues()
        recyclerView.adapter = NoteAdapter(App.noteRepository.listNotes()) {
            val listener = activity as OpenNoteListener
            listener.openNote(it)
        }

        return view
    }



        suspend fun NoteQues(id:Int)= withContext(Dispatchers.IO) {
            return@withContext App.noteRepository.listNotes()
        }

        override fun shutup() {
            super.shutup()
            thread?.cancel()
        }

}