package com.vosker.data.remote

import com.vosker.data.model.JokeApi
import io.reactivex.Single

class RemoteHelper(private val remoteService: RemoteService) {

    fun getJokes(): Single<List<JokeApi>> =
        remoteService.getJokes()
}