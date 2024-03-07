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
            setValue(Register(id, email, name, role))
        }
    }

    fun getData(onDataChange: (Register) -> Unit, onCancelled: (DatabaseError) -> Unit) {
        val gson = Gson()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.child(REGISTER).children.forEach {
                    val json = """${it.value}"""
                    onDataChange.invoke(
                        gson.fromJson(
                            json, Register::class.java
                        )
                    )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                onCancelled.invoke(error)
            }

        })
    }

    fun getData(
        username: String, onDataChange: (Register) -> Unit, onCancelled: (DatabaseError) -> Unit
    ) {
        val gson = Gson()
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.child(REGISTER).children.forEach {
                    val json = """${it.value}"""
                    if (username == it.key) onDataChange.invoke(
                        gson.fromJson(
                            json, Register::class.java
                        )
                    )
                }
            }

            override fun onCancelled(error: DatabaseError) {
                onCancelled.invoke(error)
            }

        })
    }
}