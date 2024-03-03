package com.danamon.test.module

import com.danamon.domain.usecase.GetHomeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetHomeUseCase(get()) }
}