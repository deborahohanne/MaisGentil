package br.iesb.mobile.gentil.ui.activity.representative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.RegisterActivity
//import br.iesb.mobile.gentil.ui.activity.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register_representative.*


class RegisterRepresentativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_representative)


        btSignUpRepresentante.setOnClickListener {
            cadastrar()

        }
        tvSignUpRepLinked.setOnClickListener {
//            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
//            startActivity(intencaoDeChamada)

        }
        btSignupThreeTrue.setOnClickListener {
            val intencaoDeChamada = Intent(this, RegisterActivity::class.java)
            startActivity(intencaoDeChamada)
        }
    }

    // criar funcoes fora da classe
    private fun cadastrar() {
        // recuperar dados nos campos que o usuario digitou
        val nomeInstituicao = etRepresentanteNome.text.toString()
        val email = etEmailRepresentante.text.toString()
        val password = etPasswordRepresentante.text.toString()
        val retype = etConfirmPasswordRepresentante.text.toString()

        // se digitar os valores do campo errado
        if (password != retype) {
            // mostrar na tela
            Toast.makeText(this, "Digitar a senha correta nos dois campos", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val taskDeLogin = auth.createUserWithEmailAndPassword(email, password)

        taskDeLogin.addOnCompleteListener{ resultado ->
            if (resultado.isSuccessful) {
//                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
//                val intencaoDeChamada = Intent(this, LoginActivity::class.java)
//                startActivity(intencaoDeChamada)
            } else {
                Toast.makeText(this, "Olha, deu erro no CADASTRO!", Toast.LENGTH_LONG).show()
            }

        }
    }
}