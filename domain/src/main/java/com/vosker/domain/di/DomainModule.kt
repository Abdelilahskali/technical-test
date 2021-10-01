package com.vosker.domain.di

import com.vosker.domain.usecase.GetJokeUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetJokeUseCase(jokeRepository = get()) }
}