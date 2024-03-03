package com.danamon.test.module

import com.danamon.data.mapper.HomeDataMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { HomeDataMapper() }
}