package br.iesb.mobile.gentil.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentMaisGentilBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MaisGentilFragment : Fragment() {

    private lateinit var binding: FragmentMaisGentilBinding

    //fun irParaTelaLogin(v: View) {
    //    findNavController().navigate(R.id.action_maisGentilFragment_to_mainFragment)
   // }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMaisGentilBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        GlobalScope.launch(context = Dispatchers.Main) {
            delay(4000)
            findNavController().navigate(R.id.action_maisGentilFragment_to_mainFragment)
        }

        return binding.root
    }

}