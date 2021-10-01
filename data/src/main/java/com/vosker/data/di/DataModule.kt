package com.vosker.data.di

import com.vosker.data.mapper.JokeMapper
import com.vosker.data.remote.RemoteHelper
import com.vosker.data.remote.RemoteService
import com.vosker.data.remote.RemoteServiceImpl
import com.vosker.data.repository.JokeRepositoryImpl
import com.vosker.domain.repository.JokeRepository
import org.koin.dsl.module

val dataModule = module {
    single { JokeMapper() }
    single { RemoteHelper(remoteService = get()) }
    single<RemoteService> { RemoteServiceImpl() }
    single<JokeRepository> { JokeRepositoryImpl(remoteHelper = get(), jokeMapper = get()) }
}