package com.vosker.data.remote

import com.vosker.data.model.JokeApi
import io.reactivex.Single
import retrofit2.http.*

interface RemoteService {

    @GET("jokes/ten")
    fun getJokes(): Single<List<JokeApi>>
}