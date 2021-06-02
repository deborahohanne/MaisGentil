package br.iesb.mobile.gentil.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentLoginBinding
import br.iesb.mobile.gentil.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject

//@AndroidEntryPoint
//@WithFragmentBindings
class LoginFragment : Fragment() {

//    @Inject
//    lateinit var auth: FirebaseAuth

    private lateinit var binding: FragmentLoginBinding

    fun IrParaHome(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_main)
    }

    fun IrTelaEsqueceuSenha(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
    }

//    fun IrParaTelaLogin(v: View) {
//        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        tvLoginTwo.setOnClickListener {
//            val callIntent = Intent(this, ForgotActivity::class.java)
//            startActivity(callIntent)
//        }
//
//        btLoginLogin.setOnClickListener {
//            val email = etEmailAddressLogin.text.toString()
//            val password = etPasswordLogin.text.toString()
//
//            /* *//* recuperar uma instância do firebase o objeto de autenticação *//*
//            val auth = FirebaseAuth.getInstance()*/
//
//            /* função, dentro do obj 'auth', método que recebe o email e senha para efetuar o login
//            retorna promessa de resultado */
//            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
//
//            /* verificar se foi efetuado o login com sucesso */
//            taskDeLogin.addOnCompleteListener{ resultado ->
//                if (resultado.isSuccessful) {
//                    val intentGoToHomeScreen = Intent(this, HomeVoluntaryActivity::class.java)
//                    startActivity((intentGoToHomeScreen))
//                    // Toast.makeText(this, "Olha, deu certo o Login", Toast.LENGTH_LONG).show()
//                } else {
//                    Toast.makeText(this, "Olha, deu erro no Login", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//
//        tvLoginLinked.setOnClickListener {
//            val callIntent = Intent(this, LoginActivity::class.java)
//            startActivity(callIntent)
//        }
//
//        btforgotTrueLogin.setOnClickListener {
//            val callIntent = Intent(this, MainActivity::class.java)
//            startActivity(callIntent)
//        }


        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        return binding.root

    }

}