package com.danamon.test.ui


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("role") val role: String? = null
)