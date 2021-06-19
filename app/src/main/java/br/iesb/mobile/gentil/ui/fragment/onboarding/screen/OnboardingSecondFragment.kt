package br.iesb.mobile.gentil.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.gentil.databinding.FragmentOnboardingSecondBinding


class OnboardingSecondFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingSecondBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

}