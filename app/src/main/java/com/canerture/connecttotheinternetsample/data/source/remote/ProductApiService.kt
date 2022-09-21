package com.canerture.connecttotheinternetsample.data.source.remote

import com.canerture.connecttotheinternetsample.common.Constants.GET_PRODUCTS
import com.canerture.connecttotheinternetsample.common.Constants.SEARCH_PRODUCT
import com.canerture.connecttotheinternetsample.data.model.Product
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApiService {

    @GET(GET_PRODUCTS)
    fun getProducts(): Call<List<Product>>

    @POST(SEARCH_PRODUCT)
    @FormUrlEncoded
    fun searchProduct(
        @Field("query") query: String
    ): Call<List<Product>>
}