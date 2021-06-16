package br.iesb.mobile.gentil.repository

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginRepository(private val context: Context) {

    /* recuperar uma instancia do firebase o objeto de autenticacao */
    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()


    //função de login que recebe um email, uma senha e um callback
    fun login(email: String, password: String, callback: (result: String?) -> Unit) {
        //variável que recebe a operação de login
        val operation = auth.signInWithEmailAndPassword(email, password)

        //Coloca o listener para quando completar, a gente verificar se teve sucesso ou falha
        operation.addOnCompleteListener { result ->
            if (result.isSuccessful) {
                callback("OK")
            } else {
                //variável de erro pode ser nula, caso não encontre a mensagem de erro da tarefa
                val error = result.exception?.localizedMessage
                callback(error)
            }
        }
    }


    fun register(email: String, password: String, callback: (result: String?) -> Unit) {
        //variável que recebe a operação de cadastro
        val operation = auth.createUserWithEmailAndPassword(email, password)

        //Coloca o listener para quando completar, a gente verificar se teve sucesso ou falha
        operation.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback("OK")
            } else {
                //variável de erro pode ser nula, caso não encontre a mensagem de erro da tarefa
                val error = task.exception?.localizedMessage
                callback(error)
            }
        }
    }

    fun forgot(email: String, callback: (result: String?) -> Unit) {
        /*funcao, dentro do obj 'auth', método que recebe o email e senha para efetuar o cadastro
        retorna promessa de resultado*/
        val operation = auth.sendPasswordResetEmail(email)

        //Coloca o listener para quando completar, a gente verificar se teve sucesso ou falha
        operation.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback("OK")
            } else {
                //variável de erro pode ser nula, caso não encontre a mensagem de erro da tarefa
                val error = task.exception?.localizedMessage
                callback(error)
            }
        }
    }

    fun registerUser(email: String, password: String, callback: (result: String?) -> Unit) {
        //variável que recebe a operação de cadastro
        val operation = auth.createUserWithEmailAndPassword(email, password)

        //Coloca o listener para quando completar, a gente verificar se teve sucesso ou falha
        operation.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback("OK")
            } else {
                //variável de erro pode ser nula, caso não encontre a mensagem de erro da tarefa
                val error = task.exception?.localizedMessage
                callback(error)
            }
        }
    }

}