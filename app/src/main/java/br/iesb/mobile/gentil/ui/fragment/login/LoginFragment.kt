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
import br.iesb.mobile.gentil.databinding.FragmentLoginBinding
import br.iesb.mobile.gentil.databinding.FragmentMainBinding
import br.iesb.mobile.gentil.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    fun IrTelaEsqueceuSenha(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        binding.btLoginLogin.setOnClickListener{ login() }

        return binding.root

    }

    private fun login() {
        val email = binding.etEmailAddressLogin.text.toString()
        val password = binding.etPasswordLogin.text.toString()

        viewModel.login(email, password) { response ->
            Toast.makeText(this.context, response[1], Toast.LENGTH_LONG).show()
            if (response[0] == "OK") {
                findNavController().navigate(R.id.action_loginFragment_to_main)
            }
        }
    }

}