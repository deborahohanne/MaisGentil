package br.iesb.mobile.gentil.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.gentil.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_noticias)
        bottomNavigationView.background = null
    }
}