package br.iesb.mobile.gentil.repository

import android.content.ContentValues
import android.os.strictmode.ContentUriWithoutPermissionViolation
import android.util.Log
import androidx.core.content.contentValuesOf
import br.iesb.mobile.gentil.domain.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

class TestClass {
    val database = FirebaseDatabase.getInstance()
    val auth = FirebaseAuth.getInstance()
    fun setValue() {
        val id = auth.currentUser?.uid

        val reference = database.getReference("login/$id")

        val user = User(id, "Jorge", cpf = "7448548448")
        reference.setValue(user)
//        reference.push().setValue(user)
    }

    fun getValue() {
        val id = auth.currentUser?.uid

        val  reference = database.getReference("login/$id")

        //reference.addValueEventListener()

        reference.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                Log.w(ContentValues.TAG, "$user")
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}