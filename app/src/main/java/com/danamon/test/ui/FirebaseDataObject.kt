package com.danamon.test.ui


import com.google.gson.annotations.SerializedName

data class FirebaseDataObject(
    @SerializedName("register")
    val register: Register? = null
)