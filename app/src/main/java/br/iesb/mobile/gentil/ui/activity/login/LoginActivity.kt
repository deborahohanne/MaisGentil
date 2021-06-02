package br.iesb.mobile.gentil.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.MainActivity
import br.iesb.mobile.gentil.ui.activity.voluntary.HomeVoluntaryActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

//assinatura: algo que pode receber o objeto fornecido
//@AndroidEntryPoint
//@WithFragmentBindings
class LoginActivity : AppCompatActivity() {

//    @Inject lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // utilização do módulo que fabrica o auth
        /*
        val fabric = LoginModule()
        val auth = fabric.firebaseAuthProvider()
        */
//
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
    }
}