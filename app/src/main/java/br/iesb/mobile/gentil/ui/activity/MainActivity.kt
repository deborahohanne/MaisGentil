package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.gentil.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btHome.setOnClickListener {

            val intencaoDeChamada = Intent(this, HomeActivity::class.java)
            startActivity(intencaoDeChamada)
        }

        btMainSignUp.setOnClickListener {

            val intencaoDeChamada = Intent(this, SignUpOneActivity::class.java)
            startActivity(intencaoDeChamada)
        }

        tvMainLinked.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }

    }

}
