package com.vosker.technicaltest.ui.mapper

import com.vosker.domain.model.Joke
import com.vosker.technicaltest.ui.model.JokeUiModel

class JokeUiMapper {

    fun toUiModel(jokeList: List<Joke>) = jokeList.map { it.toUiModel() }

    private fun Joke.toUiModel(): JokeUiModel = JokeUiModel(
        id = this.id ?: JOKE_ID_FALLBACK,
        type = this.type.orEmpty(),
        setup = this.setup.orEmpty(),
        punchline = this.punchline.orEmpty()
    )

    companion object {
        private const val JOKE_ID_FALLBACK = 1
    }
}