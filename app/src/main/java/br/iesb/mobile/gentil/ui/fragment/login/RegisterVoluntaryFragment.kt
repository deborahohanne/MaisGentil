package br.iesb.mobile.gentil.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.iesb.mobile.gentil.databinding.FragmentRegisterVoluntaryBinding
import br.iesb.mobile.gentil.viewmodel.LoginViewModel


class RegisterVoluntaryFragment : Fragment() {
    private lateinit var binding: FragmentRegisterVoluntaryBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterVoluntaryBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        binding.btSignUpVoluntario.setOnClickListener{ registerVoluntary() }

        return binding.root

    }

    fun registerVoluntary(){
        val email = binding.etEmailSignUpVoluntario.text.toString()
        val password = binding.etPasswordSignUpVoluntario.text.toString()
        val confirmPassword = binding.etConfirmPasswordSignUpVoluntario.text.toString()

        viewModel.registerUser(email, password, confirmPassword) { response ->
            Toast.makeText(this.context, response[1], Toast.LENGTH_LONG).show()
            if (response[0] == "OK") {
                Toast.makeText(this.context, response[1], Toast.LENGTH_LONG).show()
            }
        }

    }

}