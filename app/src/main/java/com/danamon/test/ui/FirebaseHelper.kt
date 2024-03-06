package com.danamon.test.ui

import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.gson.Gson

object FirebaseHelper {
    const val REGISTER = "register"
    private var reference: DatabaseReference = Firebase.database.reference
    fun setData(name: String, email: String) {
        reference.child(REGISTER).apply {
            child("name").setValue(name)
            child("email").setValue(email)
        }
    }

    fun getData(onDataChange: (FirebaseDataObject) -> Unit, onCancelled: (DatabaseError) -> Unit) {
        val gson = Gson()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val json = """${snapshot.value}"""
                onDataChange.invoke(gson.fromJson(json, FirebaseDataObject::class.java))
            }

            override fun onCancelled(error: DatabaseError) {
                onCancelled.invoke(error)
            }

        })
    }
}