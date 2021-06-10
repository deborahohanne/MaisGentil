package br.iesb.mobile.gentil.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.iesb.mobile.gentil.R
import br.iesb.mobile.gentil.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    /* definições de variáveis referente ao 'radio group' da tela*/
    var radioGroup: RadioGroup? = null
    private lateinit var radioButton: RadioButton
    lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        // o código é a própria classe
        binding.codigoFragmento = this
        // o código define o ciclo de vida do fragmento
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radioGroup = binding.rgSignupOne
        button = binding.btSignUpOne

        button.setOnClickListener { buttonCheck() }

    }

    private fun buttonCheck() {
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId

        if (intSelectButton.equals(rbCheckVoluntario)) {
            findNavController().navigate(R.id.action_registerFragment_to_registerVoluntaryFragment)
        }

        if (intSelectButton.equals(rbCheckRepresentante)) {
            findNavController().navigate(R.id.action_registerFragment_to_registerRepresentativeFragment)
        }
    }


}

