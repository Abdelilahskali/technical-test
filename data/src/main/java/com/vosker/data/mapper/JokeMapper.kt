package com.vosker.data.mapper

import com.vosker.data.model.JokeApi
import com.vosker.domain.model.Joke

class JokeMapper {

    fun toDomain(jokeApiList: List<JokeApi>): List<Joke> = jokeApiList.map { jokeApi ->
        jokeApi.toDomain()
    }

    private fun JokeApi.toDomain(): Joke = Joke(
        id = this.id,
        type = this.type,
        setup = this.setup,
        punchline = this.punchline
    )
}