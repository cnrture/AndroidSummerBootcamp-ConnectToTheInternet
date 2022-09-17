package com.canerture.connecttotheinternetsample.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.canerture.connecttotheinternetsample.R
import com.canerture.connecttotheinternetsample.common.ApiUtils
import com.canerture.connecttotheinternetsample.common.viewBinding
import com.canerture.connecttotheinternetsample.data.model.Product
import com.canerture.connecttotheinternetsample.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val productsAdapter by lazy { ProductsAdapter() }

    private val service = ApiUtils.productApiService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsAdapter.onProductClick = {
            val action = HomeFragmentDirections.homeToDetail(it)
            findNavController().navigate(action)
        }

        service.getProducts().enqueue(object : Callback<List<Product>?> {

            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                response.body()?.let {
                    productsAdapter.submitList(it)
                    binding.rvProducts.adapter = productsAdapter
                }
            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }
        })
    }
}