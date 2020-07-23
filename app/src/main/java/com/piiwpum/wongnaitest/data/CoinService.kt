package com.piiwpum.wongnaitest.data

import com.piiwpum.wongnaitest.model.ResponseModel
import io.reactivex.Flowable
import retrofit2.http.GET

interface CoinService {

    @GET("/v1/public/coins")
    fun getCoins(): Flowable<ResponseModel>
}