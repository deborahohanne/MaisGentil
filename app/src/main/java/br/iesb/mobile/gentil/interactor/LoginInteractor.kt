package br.iesb.mobile.gentil.interactor
import android.content.Context
import br.iesb.mobile.gentil.repository.LoginRepository


class LoginInteractor(private val context: Context) {

    //Variável que chama o repository
    private val repository = LoginRepository(context)

    fun login(email: String, password: String, callback: (result: String?) -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            callback("VAZIO")
        } else {
            repository.login(email, password, callback)
        }
    }

    fun forgot(email: String, callback: (result: String?) -> Unit) {
        if (email.isEmpty()) {
            callback("VAZIO")
        } else {
            repository.forgot(email, callback)
        }
    }

    fun registerUser(
        email: String,
        password: String,
        confirmPassword: String,
        callback: (result: String?) -> Unit
    ) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            callback("VAZIO")
        } else if (password.length < 6) {
            callback("SENHA")
        } else if (password != confirmPassword) {
            callback("SENHAS")
        } else {
            repository.registerUser(email, password, callback)
        }
    }

}