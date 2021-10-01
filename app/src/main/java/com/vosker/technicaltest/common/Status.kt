package com.vosker.technicaltest.common

sealed class Status {

    object Loading : Status()
    object Success : Status()
    object Error : Status()
}