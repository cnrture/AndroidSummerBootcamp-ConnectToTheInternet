package com.canerture.connecttotheinternetsample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.connecttotheinternetsample.data.ProductRepository
import com.canerture.connecttotheinternetsample.data.model.Product

class HomeViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private var _productList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?>
        get() = _productList

    init {
        products()
    }

    fun products() {
        productRepository.getProducts()
        _productList = productRepository.productList
    }

    fun searchProduct(query: String) {
        productRepository.searchProduct(query)
        _productList = productRepository.productList
    }
}