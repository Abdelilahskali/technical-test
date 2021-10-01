package com.vosker.technicaltest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vosker.domain.usecase.GetJokeUseCase
import com.vosker.technicaltest.common.Resource
import com.vosker.technicaltest.ui.mapper.JokeUiMapper
import com.vosker.technicaltest.ui.model.JokeUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JokeViewModel(
    private val getJokeUseCase: GetJokeUseCase,
    private val jokeUiMapper: JokeUiMapper,
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun getJokes(): LiveData<Resource<List<JokeUiModel>>> {

        val liveData = MutableLiveData<Resource<List<JokeUiModel>>>()
        liveData.postValue(Resource.loading(null))

        compositeDisposable.add(
            getJokeUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    liveData.postValue(Resource.success(jokeUiMapper.toUiModel(response)))
                }, { throwable ->
                    liveData.postValue(Resource.error("${throwable.message}", null))
                    Log.e(TAG, "${throwable.message}")
                })
        )

        return liveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    companion object {
        private val TAG = JokeViewModel::class.java.simpleName
    }

}