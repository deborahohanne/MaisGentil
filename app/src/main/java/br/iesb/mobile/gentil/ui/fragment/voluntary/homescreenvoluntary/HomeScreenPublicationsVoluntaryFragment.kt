package br.iesb.mobile.gentil.ui.fragment.voluntary.homescreenvoluntary

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.adapter.NoteListAdapter
import br.iesb.mobile.gentil.model.Note
import kotlinx.android.synthetic.main.fragment_home_screen_publications.*

class HomeScreenPublicationsVoluntaryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = context?.let { NoteListAdapter(notes(), it) }

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }


    private fun notes(): List<Note> {
        return listOf(
            Note("Leitura",
                "Livro de Kotlin com Android"),
            Note("Pesquisa",
                "Como posso melhorar o código dos meus projetos"),
            Note("Estudo",
                "Como sincronizar minha App com um Web Service"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen_publications, container, false)
    }
}