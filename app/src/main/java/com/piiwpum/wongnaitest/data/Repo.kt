package com.piiwpum.wongnaitest.data

import com.piiwpum.wongnaitest.model.ResponseModel
import io.reactivex.Flowable

class Repo constructor(private val retrofitClient: RetrofitClient) : CoinService {
    override fun getCoins(): Flowable<ResponseModel> {
        return retrofitClient.getClient().getCoins()
    }

}