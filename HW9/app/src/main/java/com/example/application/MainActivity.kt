package com.example.application

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
//import javax.swing.text.View


class MainActivity : AppCompatActivity(), NoteListFragment.OpenNoteListener {

    companion object {
        private val NOTE_FRAGMENT_TAG = "note"
        private val NOTE_BACK_STACK_NAME = "note"
    }

    private fun noteContainerExists(): Boolean {
        return findViewById<View>(R.id.note_fragment_container) != null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = getString(R.string.notes_title)


        val oldNote = supportFragmentManager.findFragmentByTag(NOTE_FRAGMENT_TAG) as? NoteFragment
        if (oldNote != null) {
            oldNote.getNoteId()?.let {
                openNote(it)
            }
        }
        if (oldNote == null || noteContainerExists()) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, NoteListFragment())
            fragmentTransaction.commit()
        }

    }

    override fun openNote(id: Int) {
        supportFragmentManager.popBackStackImmediate(NOTE_BACK_STACK_NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(NOTE_BACK_STACK_NAME)

        val fragment = NoteFragment.newInstance(id)
        val container = if (noteContainerExists())
            R.id.note_fragment_container
        else
            R.id.fragment_container
        fragmentTransaction.replace(container, fragment, NOTE_FRAGMENT_TAG)
        fragmentTransaction.commit()
    }

}
