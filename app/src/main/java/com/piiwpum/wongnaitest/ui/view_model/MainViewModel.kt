package com.piiwpum.wongnaitest.ui.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.piiwpum.wongnaitest.data.Repo
import com.piiwpum.wongnaitest.model.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel constructor(private val repo: Repo) : ViewModel() {
    private val _response: MutableLiveData<ResponseModel> = MutableLiveData()
    var responseModel: LiveData<ResponseModel> = _response

    init {
        featchData()
    }


    fun featchData() {
        repo.getCoins().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _response.postValue(it)

            }, { t: Throwable? ->
                Log.d("error_viewmodel", t?.message)

            })
    }
}