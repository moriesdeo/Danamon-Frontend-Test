package com.danamon.test.ui

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

object FirebaseHelper {
    const val REGISTER = "register"
    private var reference: DatabaseReference = Firebase.database.reference
    fun setData(name: String, email: String, role: String, id: Int) {
        reference.child(REGISTER).child(name).apply {
            child("name").setValue(name)
            child("email").setValue(email)
            child("role").setValue(role)
            child("id").setValue(id)
        }
    }

    fun getData(
        username: String, onDataChange: (Register) -> Unit, onCancelled: (DatabaseError) -> Unit
    ) {
        val gson = Gson()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    val json = """${ds.child(username).value}"""
                    onDataChange.invoke(gson.fromJson(json, Register::class.java))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                onCancelled.invoke(error)
            }

        })
    }
}