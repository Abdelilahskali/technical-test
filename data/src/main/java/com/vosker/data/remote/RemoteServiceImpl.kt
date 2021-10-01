package com.vosker.data.remote

import com.vosker.data.model.JokeApi
import io.reactivex.Single

class RemoteServiceImpl : RemoteService {

    override fun getJokes(): Single<List<JokeApi>> =
        RemoteHelper(RemoteBuilder.remote).getJokes()
}