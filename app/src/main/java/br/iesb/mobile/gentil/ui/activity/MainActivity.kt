package br.iesb.mobile.gentil.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.gentil.R
//import br.iesb.mobile.gentil.ui.activity.login.LoginActivity

import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingThreeFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        btHome.setOnClickListener {
//            val callIntent = Intent(this, HomeActivity::class.java)
//            startActivity(callIntent)
//        }
//
//        tvMainSignUp.setOnClickListener {
//            val callIntent = Intent(this, RegisterActivity::class.java)
//            startActivity(callIntent)
//        }
//
//        tvMainLinked.setOnClickListener {
////            val callIntent = Intent(this, LoginActivity::class.java)
////            startActivity(callIntent)
//        }


       /* criar a fonte de dados
        cria o fragmento em memória, chama o onCreateView() e recupera o .xml que o representa, e deixar pronto para apresentar */
        val listOfFragments = listOf(
            OnboardingFirstFragment(),
            OnboardingSecondFragment(),
            OnboardingThreeFragment()
        )

        /* faz a comunicação entre a lista de dados em memória, lista de fragmentos e a ViewPage */
        val adapterOnboarding = AdapterToChatViewPage(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )

        vpOnboarding.adapter = adapterOnboarding
    }
}

/* criar adaptador para 'conversar" com a ViewPage */
class AdapterToChatViewPage(
   val listOfFragments: List<Fragment>,
   fragmentManager: FragmentManager,
   lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

   override fun getItemCount() = listOfFragments.size

   override fun createFragment(position: Int) = listOfFragments[position]
}
