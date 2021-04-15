package br.iesb.mobile.gentil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up_three.*

class SignUpThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_three)


        btSignUpRepresentante.setOnClickListener {
            val intencaoDeChamada = Intent(this, HomeActivity::class.java)
            startActivity(intencaoDeChamada)

        }
        tvSignUpRepLinked.setOnClickListener {
            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)

        }
        btSignUpThreeVoltar.setOnClickListener {
            val intencaoDeChamada = Intent(this, SignUpOneActivity::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}