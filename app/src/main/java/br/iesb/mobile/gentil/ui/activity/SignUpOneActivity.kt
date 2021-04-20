package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import br.iesb.mobile.gentil.R
import kotlinx.android.synthetic.main.activity_sign_up_one.*

class SignUpOneActivity : AppCompatActivity() {

    var radioGroup: RadioGroup? = null
    private lateinit var radioButton: RadioButton
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_one)

        radioGroup = findViewById(R.id.rgSignupOne)
        button = findViewById(R.id.btSignUpOne)

        button.setOnClickListener {

            val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
            radioButton = findViewById(intSelectButton)

            if (radioButton.equals(rbCheckVoluntario)) {
                val intencaoDeChamada = Intent(this, SignUpTwoActivity::class.java)
                startActivity(intencaoDeChamada)
            }

            if (radioButton.equals(rbCheckRepresentante)){
                val intencaoDeChamada = Intent(this, SignUpThreeActivity::class.java)
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