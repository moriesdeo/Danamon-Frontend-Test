package com.danamon.core.extension

import com.danamon.core.data.Resource

fun <T> Resource<T>.data(): T? {
    return when (this) {
        is Resource.Success -> this.model
        else -> null
    }
}