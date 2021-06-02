package br.iesb.mobile.gentil.interactor

import android.content.Context
import br.iesb.mobile.gentil.repository.LoginRepository
import br.iesb.mobile.gentil.AppResult
import  br.iesb.mobile.gentil.domain.User

class LoginInteractor(context: Context) {

    private val loginRepository = LoginRepository(context)

    fun login(email: String, password: String, callback: (result: AppResult<User>) -> Unit) {

        //TODO: Validate email and password

        loginRepository.login(email, password, callback)
    }

}