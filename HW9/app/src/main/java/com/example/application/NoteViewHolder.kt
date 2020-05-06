package com.example.application

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.application.data.Note
import java.text.SimpleDateFormat

class NoteViewHolder(itemView: View, private val clickHandler: (Int) -> Unit):
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var view = itemView
    private var note: Note? = null

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        note?.let {
            clickHandler(it.id)
        }
    }

    fun bind(note: Note) {
        this.note = note
        view.noteText.text = note.text
        view.noteDate.text = SimpleDateFormat(view.context.getString(R.string.date_format)).format(note.date)
        view.noteImage.setImageDrawable(view.context.getDrawable(note.drawableRes))
    }

}