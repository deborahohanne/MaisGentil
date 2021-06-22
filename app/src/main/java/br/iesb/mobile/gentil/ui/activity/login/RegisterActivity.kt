package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.iesb.mobile.gentil.R
//import br.iesb.mobile.gentil.ui.activity.login.LoginActivity
import br.iesb.mobile.gentil.ui.activity.representative.RegisterRepresentativeActivity
import br.iesb.mobile.gentil.ui.activity.voluntary.RegisterVoluntaryActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

   /* definições de variáveis referente ao 'radio group' da tela*/
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
                val callIntent = Intent(this, RegisterVoluntaryActivity::class.java)
                startActivity(callIntent)
            }

            if (radioButton.equals(rbCheckRepresentante)){
                val callIntent = Intent(this, RegisterRepresentativeActivity::class.java)
                startActivity(callIntent)
            }

        // Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()

        }
        tvSignUpLoginLinked.setOnClickListener {
//            val callIntent = Intent(this, LoginActivity::class.java)
//            startActivity(callIntent)
        }
        btSignupVoltarTrue.setOnClickListener {
            val callIntent = Intent(this, MainActivity::class.java)
            startActivity(callIntent)
        }

    }

}