package br.iesb.mobile.gentil.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.gentil.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot.*

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        btForgot.setOnClickListener {
            val email = etForgotEmail.text.toString()
            /* recuperar uma instancia do firebase o objeto de autenticacao */
            val auth = FirebaseAuth.getInstance()
            /*funcao, dentro do obj 'auth', método que recebe o email e senha para efetuar o cadastro
            retorna promessa de resultado*/
            auth.sendPasswordResetEmail(email)

            /* no lugar do 'this': apontando para instancia da atividade que é o contexto
             quando é criado o 'toast', ele precisava do 'this'
             agora dentro do fragmento, ele não é contexto, mas a variável 'activity' aponta para a atividade
             a qual o fragmento foi foi anexado */
            Toast.makeText(this, "Você receberá um email, olhe a sua caixa", Toast.LENGTH_LONG).show()

            /* quando eu quero finalizar uma atividade onde o fragmento está linkado eu utilizo
             um método que encerra que é a 'activity', o ponto de '?' é porque ela pode estar nula
             se a atividade tiver 'nula' naoq quebra o fragmento, somente se tiver algo */
            finish()

        }

        btforgotTrue.setOnClickListener {
            val callIntent = Intent(this, LoginActivity::class.java)
            startActivity(callIntent)
        }

    }
}