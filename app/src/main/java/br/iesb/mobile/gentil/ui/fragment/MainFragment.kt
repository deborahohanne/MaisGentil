package br.iesb.mobile.gentil.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    // classe específica que vem tudo do arquivo xml
    private lateinit var binding: FragmentMainBinding

    fun irParaTelaCadastro(v: View) {
        findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
    }

    fun irParaTelaLogin(v: View) {
        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
    }

    // equivalente ao onCreate da atividade
    // vínculo parte visual com o código
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        return binding.root
    }

}