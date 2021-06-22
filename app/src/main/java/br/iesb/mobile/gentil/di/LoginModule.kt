package br.iesb.mobile.gentil.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// vai existir uma única fábrica para o app inteiro
@Module
@InstallIn(SingletonComponent::class)
class LoginModule {
    // função que retorna objeto do firebaseauth
    // provedor das informações do hilt
    // @Provides: assinatura, provedor de objeto
    @Provides
    fun firebaseAuthProvider() = Firebase.auth

}