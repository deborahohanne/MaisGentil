package br.iesb.mobile.gentil.ui.fragment.voluntary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.gentil.R


class HomeVoluntaryFragment : Fragment() {

//    private lateinit var binding: FragmentHomeVoluntaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        binding = FragmentHomeVoluntaryBinding.inflate(inflater, container, false)
//
//        // o código é a própria classe
//        binding.codigoFragmento = this
//        // o código define o ciclo de vida do fragmento
//        binding.lifecycleOwner = this

        return inflater.inflate(R.layout.fragment_home_voluntary, container, false)
    }

}