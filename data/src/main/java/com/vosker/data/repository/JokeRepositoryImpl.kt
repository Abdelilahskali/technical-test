package com.vosker.data.repository

import com.vosker.data.mapper.JokeMapper
import com.vosker.data.remote.RemoteHelper
import com.vosker.domain.model.Joke
import com.vosker.domain.repository.JokeRepository
import io.reactivex.Single

class JokeRepositoryImpl(
    private val remoteHelper: RemoteHelper,
    private val jokeMapper: JokeMapper
) : JokeRepository {

    override fun getJokes(): Single<List<Joke>> = remoteHelper.getJokes().map { jokeApi ->
        jokeMapper.toDomain(jokeApi)
    }

}