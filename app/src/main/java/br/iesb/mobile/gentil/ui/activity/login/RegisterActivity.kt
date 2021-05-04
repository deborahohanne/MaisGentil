package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.login.LoginActivity
import br.iesb.mobile.gentil.ui.activity.representative.RegisterRepresentativeActivity
import br.iesb.mobile.gentil.ui.activity.voluntary.RegisterVoluntaryActivity
import kotlinx.android.synthetic.main.activity_register.*

class SignUpOneActivity : AppCompatActivity() {

    var radioGroup: RadioGroup? = null
    private lateinit var radioButton: RadioButton
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        radioGroup = findViewById(R.id.rgSignupOne)
        button = findViewById(R.id.btSignUpOne)

        button.setOnClickListener {

            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)

            if (radioButton.equals(rbCheckVoluntario)) {
                val intencaoDeChamada = Intent(this, RegisterVoluntaryActivity::class.java)
                startActivity(intencaoDeChamada)
            }

            if (radioButton.equals(rbCheckRepresentante)){
                val intencaoDeChamada = Intent(this, RegisterRepresentativeActivity::class.java)
                startActivity(intencaoDeChamada)
            }

        // Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()

        }
        tvSignUpLoginLinked.setOnClickListener {

            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }
        btSignupVoltarTrue.setOnClickListener {
            val intencaoDeChamada = Intent(this, MainActivity::class.java)
            startActivity(intencaoDeChamada)
        }

    }

}