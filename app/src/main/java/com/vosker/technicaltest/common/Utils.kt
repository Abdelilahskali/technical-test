package com.vosker.technicaltest.common

import android.text.SpannableStringBuilder
import androidx.core.text.bold

object Utils {

    fun buildItemLabel(value: String, label: String): SpannableStringBuilder =
        SpannableStringBuilder().bold {
            append(label)
        }.append(value)
}