package br.iesb.mobile.gentil.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.model.Note
import br.iesb.mobile.gentil.ui.fragment.voluntary.homescreenvoluntary.HomeScreenPublicationsVoluntaryFragment
import kotlinx.android.synthetic.main.note_item.view.*


class NoteListAdapter(private val notes: List<Note>,
                      private val context: Context
) : Adapter<NoteListAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder?.let {
            it.bindView(note)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(this.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
        }
    }

}

