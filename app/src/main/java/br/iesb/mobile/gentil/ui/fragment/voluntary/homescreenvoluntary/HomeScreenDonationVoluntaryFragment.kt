package br.iesb.mobile.gentil.ui.fragment.voluntary.homescreenvoluntary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.gentil.AnuncioAdapter
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.model.anuncio
import br.iesb.mobile.gentil.model.fakeAnuncios
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.fragment_home_screen_donation.*
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenDonationVoluntaryFragment : Fragment() {
    private lateinit var adapter: AnuncioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fakeit.init()

        adapter = AnuncioAdapter(fakeAnuncios())
        recyclerView_MeusAnuncios.adapter = adapter
        recyclerView_MeusAnuncios.layoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen_donation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}