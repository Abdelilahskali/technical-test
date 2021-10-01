package com.vosker.technicaltest.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JokeUiModel(
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String,
) : Parcelable