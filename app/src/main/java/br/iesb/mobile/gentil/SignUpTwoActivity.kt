package br.iesb.mobile.gentil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up_two.*

class SignUpTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_two)

        btSignUpVoluntario.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }
        tvSignUpVoluntarioThree.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }
        btSignUpTwoVoltar.setOnClickListener {
            val intencaoDeChamada = Intent(this, SignUpOneActivity::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}