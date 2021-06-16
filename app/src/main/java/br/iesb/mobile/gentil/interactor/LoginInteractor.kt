package br.iesb.mobile.gentil.interactor
import android.content.Context
import br.iesb.mobile.gentil.repository.LoginRepository


class LoginInteractor(private val context: Context) {

    //Variável que chama o repository
    private val repository = LoginRepository(context)

    // função de login que verifica o email e a senha e manda pro repository fazer a validação com o authenticator do firebase
    fun login(email: String, password: String, callback: (result: String?) -> Unit) {
        //Faz a verificação necessária (regras de negócio)
        //Se estiver tudo ok (else), ele chama a função do repository
        if (email.isEmpty() || password.isEmpty()) {
            callback("VAZIO")
        } else {
            //Como o resultado vai vir da repository e não precisa fazer nenhuma verificação
            // do que vem de la, passa-se o callback como parâmetro para a função do repository
            // já fazer o feedback pra view model
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
        //Faz a verificação necessária (regras de negócio)
        //Se estiver tudo ok (else), ele chama a função do repository
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            callback("VAZIO")
        } else if (password.length < 6) {
            callback("SENHA")
        } else if (password != confirmPassword) {
            callback("SENHAS")
        } else {
            //Como o resultado vai vir da repository e não precisa fazer nenhuma verificação
            // do que vem de la, passa-se o callback como parâmetro para a função do repository
            // já fazer o feedback pra view model
            repository.registerUser(email, password, callback)
        }
    }

}