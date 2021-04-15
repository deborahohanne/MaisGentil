package br.iesb.mobile.gentil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up_one.*

class SignUpOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_one)

        btSignUpOne.setOnClickListener {


        }
        tvSignUpLoginLinked.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }
        btSignUpOneVoltar.setOnClickListener {
            val intencaoDeChamada = Intent(this, MainActivity::class.java)
            startActivity(intencaoDeChamada)
        }

    }
}