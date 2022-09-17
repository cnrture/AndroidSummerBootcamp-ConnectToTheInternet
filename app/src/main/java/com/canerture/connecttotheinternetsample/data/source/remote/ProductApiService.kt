package com.canerture.connecttotheinternetsample.data.source.remote

import com.canerture.connecttotheinternetsample.common.Constants.GET_PRODUCTS
import com.canerture.connecttotheinternetsample.data.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApiService {

    @GET(GET_PRODUCTS)
    fun getProducts(): Call<List<Product>?>
}