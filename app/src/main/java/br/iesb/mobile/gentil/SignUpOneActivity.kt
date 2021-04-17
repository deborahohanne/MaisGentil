package br.iesb.mobile.gentil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_sign_up_one.*

class SignUpOneActivity : AppCompatActivity() {

    lateinit var checkVoluntario : CheckBox
    lateinit var checkRepresentante : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_one)

        btSignUpOne.setOnClickListener {
            checkVoluntario = this.findViewById(R.id.cbVoluntario);

            if (checkVoluntario.isChecked) {
                val intencaoDeChamada = Intent(this, SignUpTwoActivity::class.java)
                startActivity(intencaoDeChamada)
            }

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