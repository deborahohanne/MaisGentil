package br.iesb.mobile.gentil.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.ui.activity.splash.screen.SplashScreenFragment

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val listaFragmentos = listOf(
            SplashScreenFragment()
        )

        val adaptador = AdaptadorParaConversarComVpLoading(
            listaFragmentos,
            supportFragmentManager,
            lifecycle
        )

//        vpSplashScreen.adapter = adaptador


    }

}
class AdaptadorParaConversarComVpLoading(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = listaFragmentos.size

    override fun createFragment(position: Int) = listaFragmentos[position]
}

