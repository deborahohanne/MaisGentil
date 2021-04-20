package br.iesb.mobile.gentil.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import br.iesb.mobile.gentil.ui.activity.splash.screen.SplashScreenFragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.gentil.ui.activity.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.gentil.ui.activity.onboarding.screen.OnboardingThreeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash_screen.*

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

        // criar a fonte de dados
        // cria o fragmento em memória, chama o onCreateView() e recupera o .xml que o representa, e deixar pronto para apresentar
        val listaFragmentos = listOf(
            OnboardingFirstFragment(),
            OnboardingSecondFragment(),
            OnboardingThreeFragment()
        )

        // criar adaptador
        val adaptador = AdaptadorParaConversarComVp(
            listaFragmentos,
            supportFragmentManager,
            lifecycle
        )

        vpOnboarding.adapter = adaptador
    }
}


class AdaptadorParaConversarComVp(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = listaFragmentos.size

    override fun createFragment(position: Int) = listaFragmentos[position]
}

