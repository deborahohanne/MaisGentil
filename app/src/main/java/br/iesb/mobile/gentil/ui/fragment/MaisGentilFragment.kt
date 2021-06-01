package br.iesb.mobile.gentil.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentMainBinding
import br.iesb.mobile.gentil.databinding.FragmentMaisGentilBinding


class MaisGentilFragment : Fragment() {

    private lateinit var binding: FragmentMaisGentilBinding

    fun irParaTelaLogin(v: View) {
        findNavController().navigate(R.id.action_maisGentilFragment_to_mainFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMaisGentilBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        return binding.root
    }

}