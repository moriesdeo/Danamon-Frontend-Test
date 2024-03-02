package com.danamon.core.extension

import com.danamon.core.network.Mapper

fun <A, B> A.mapTo(mapper: Mapper<A, B>): B {
    return mapper.to(this)
}


