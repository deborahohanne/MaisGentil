package br.iesb.mobile.gentil.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.HomeActivity
import br.iesb.mobile.gentil.ui.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvLoginTwo.setOnClickListener {

            val intencaoDeChamada = Intent(this, ForgotActivity::class.java)
            startActivity(intencaoDeChamada)
        }
        btLoginLogin.setOnClickListener {

            val email = etEmailAddressLogin.text.toString()
            val password = etPasswordLogin.text.toString()

            // recuperar uma instancia do firebase o objeto de autenticacao
            val auth = FirebaseAuth.getInstance()

            // funcao, dentro do obj 'auth', método que recebe o email e senha para efetuar o login
            // retorna promessa de resultado
            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)

            // verificar se foi efetuado o login com sucesso
            // -.  o que quero fazer depois
            taskDeLogin.addOnCompleteListener{ resultado ->
                if (resultado.isSuccessful) {
                    val intentIrParaTelaHome = Intent(this, HomeActivity::class.java)
                    startActivity((intentIrParaTelaHome))
                    // Toast.makeText(this, "Olha, deu certo o Login", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Olha, deu erro no Login", Toast.LENGTH_LONG).show()
                }
            }
        }

        tvLoginLinked.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)

        }

        btforgotTrueLogin.setOnClickListener {
            val intencaoDeChamada = Intent(this, MainActivity::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}