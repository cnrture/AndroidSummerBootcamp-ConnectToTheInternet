package com.canerture.connecttotheinternetsample.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.canerture.connecttotheinternetsample.common.ApiUtils
import com.canerture.connecttotheinternetsample.data.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val service = ApiUtils.productApiService

    val productList = MutableLiveData<List<Product>?>()

    fun getProducts() {

        service.getProducts().enqueue(object : Callback<List<Product>> {

            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.body().isNullOrEmpty()) {
                    productList.value = null
                } else {
                    productList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }
        })
    }

    fun searchProduct(query: String) {

        service.searchProduct(query).enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.body().isNullOrEmpty()) {
                    productList.value = null
                } else {
                    productList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }
        })
    }
}