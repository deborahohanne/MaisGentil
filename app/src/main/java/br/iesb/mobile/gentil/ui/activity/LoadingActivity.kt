package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import br.iesb.mobile.gentil.R

import kotlinx.android.synthetic.main.activity_loading.*

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        btGentil.setOnClickListener {
            val intencaoDeChamada = Intent(this, MainActivity::class.java)
            startActivity(intencaoDeChamada)

        }
    }
}