package br.iesb.mobile.gentil.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProvider
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentRegisterRepresentativeBinding
import br.iesb.mobile.gentil.viewmodel.LoginViewModel


class RegisterRepresentativeFragment : Fragment() {

    private lateinit var binding: FragmentRegisterRepresentativeBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterRepresentativeBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this


        return binding.root
    }
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.genero_outro ->
                    if (checked) {
                        // Gênero prefiro não informar
                    }
                R.id.genero_masculino ->
                    if (checked) {
                        // Gênero masculino
                    }
                R.id.genero_feminino ->
                    if (checked) {
                        // Gênero feminino
                    }
            }
        }
    }
}