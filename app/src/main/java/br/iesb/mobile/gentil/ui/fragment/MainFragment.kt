package br.iesb.mobile.gentil.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentMainBinding
import br.iesb.mobile.gentil.ui.activity.AdapterToChatViewPage
import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.gentil.ui.fragment.onboarding.screen.OnboardingThreeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment() : Fragment() {
    // classe específica que vem tudo do arquivo xml
    private lateinit var binding: FragmentMainBinding


    fun irParaTelaCadastro(v: View) {
        findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
    }

    fun irParaTelaLogin(v: View) {
        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
    }

    // equivalente ao onCreate da atividade
    // vínculo parte visual com o código
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)

        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: resolver esse problema com o onboarding
//        /* criar a fonte de dados
//        cria o fragmento em memória, chama o onCreateView() e recupera o .xml que o representa, e deixar pronto para apresentar */
//        val listOfFragments = listOf(
//            OnboardingFirstFragment(),
//            OnboardingSecondFragment(),
//            OnboardingThreeFragment()
//        )
//
//        /* faz a comunicação entre a lista de dados em memória, lista de fragmentos e a ViewPage */
//        val adapterOnboarding = AdapterToChatViewPage(
//            listOfFragments,
//            supportFragmentManager,
//            lifecycle
//        )
//
//        vpOnboarding.adapter = adapterOnboarding

       }
}

///* criar adaptador para 'conversar" com a ViewPage */
//class AdapterToChatViewPage(
//    val listOfFragments: List<Fragment>,
//    fragmentManager: FragmentManager,
//    lifecycle: Lifecycle
//) : FragmentStateAdapter(fragmentManager, lifecycle) {
//
//    override fun getItemCount() = listOfFragments.size
//
//    override fun createFragment(position: Int) = listOfFragments[position]
//}