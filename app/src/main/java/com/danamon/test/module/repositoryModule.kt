package com.danamon.test.module

import com.danamon.data.repository.HomeRepositoryImpl
import com.danamon.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(get(), get())
    }
}