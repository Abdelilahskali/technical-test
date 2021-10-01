package com.vosker.domain.usecase

import com.vosker.domain.model.Joke
import com.vosker.domain.repository.JokeRepository
import io.reactivex.Single

class GetJokeUseCase(private val jokeRepository: JokeRepository) : () -> Single<List<Joke>> {

    override fun invoke(): Single<List<Joke>> = jokeRepository.getJokes()

}