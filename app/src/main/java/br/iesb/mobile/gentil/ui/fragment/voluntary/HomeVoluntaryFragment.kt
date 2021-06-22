package br.iesb.mobile.gentil.ui.fragment.voluntary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentHomeVoluntaryBinding


class HomeVoluntaryFragment : Fragment() {

    private lateinit var binding: FragmentHomeVoluntaryBinding

    fun irParaTelaCreateAdVoluntary(v: View) {
        findNavController().navigate(R.id.action_homeVoluntaryFragment_to_createAddVoluntary)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeVoluntaryBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        return binding.root
    }

}