package com.canerture.connecttotheinternetsample.common

import com.canerture.connecttotheinternetsample.common.Constants.BASE_URL
import com.canerture.connecttotheinternetsample.data.source.remote.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val productApiService: ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
}