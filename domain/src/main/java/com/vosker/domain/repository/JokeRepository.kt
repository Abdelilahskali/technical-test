package com.vosker.domain.repository

import com.vosker.domain.model.Joke
import io.reactivex.Single

interface JokeRepository {

    fun getJokes() : Single<List<Joke>>

}