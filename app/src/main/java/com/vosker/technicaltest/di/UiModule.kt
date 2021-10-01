package com.vosker.technicaltest.di

import com.vosker.technicaltest.ui.JokeViewModel
import com.vosker.technicaltest.ui.mapper.JokeUiMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    single { JokeUiMapper() }

    viewModel {
        JokeViewModel(
            getJokeUseCase = get(),
            jokeUiMapper = get()
        )
    }
}