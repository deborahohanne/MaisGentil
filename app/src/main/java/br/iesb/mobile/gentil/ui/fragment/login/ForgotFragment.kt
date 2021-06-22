package br.iesb.mobile.gentil.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentForgotBinding
import br.iesb.mobile.gentil.databinding.FragmentLoginBinding
import br.iesb.mobile.gentil.viewmodel.LoginViewModel


class ForgotFragment : Fragment() {

    private lateinit var binding: FragmentForgotBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        binding.btForgot.setOnClickListener{ forgot() }

        return binding.root
    }

    private fun forgot() {
        val email = binding.etForgotEmail.text.toString()

        viewModel.forgot(email) { response ->
            if (response[0] == "OK") {
                Toast.makeText(this.context, response[1], Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this.context, response[1], Toast.LENGTH_LONG).show()
            }
            
        }
    }

}