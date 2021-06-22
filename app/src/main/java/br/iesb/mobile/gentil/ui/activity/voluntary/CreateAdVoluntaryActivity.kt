package br.iesb.mobile.gentil.ui.activity.voluntary

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.gentil.R
import kotlinx.android.synthetic.main.activity_create_ad_voluntary.*

class CreateAdVoluntaryActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_ad_voluntary)

    }
}