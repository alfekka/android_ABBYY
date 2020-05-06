package com.example.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class NoteFragment : Fragment() {

    companion object {
        private const val NOTE_ID = "noteId"

        fun newInstance(id: Long): NoteFragment {
            val fragment = NoteFragment()
            val args = Bundle()
            if (id != null) {
                args.putLong(NOTE_ID, id)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val note = App.noteRepository.getNoteWithId(arguments?.getInt(NOTE_ID, 1) ?: 1)
        if (note != null) {
            view.noteText.text = note.text
            view.noteImage.setImageDrawable(activity?.getDrawable(note.drawableRes))
        }
    }

    fun getNoteId(): Int? = arguments?.getInt(NOTE_ID)

}