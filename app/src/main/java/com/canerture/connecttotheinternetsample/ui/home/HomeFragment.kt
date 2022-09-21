package com.canerture.connecttotheinternetsample.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.canerture.connecttotheinternetsample.R
import com.canerture.connecttotheinternetsample.common.viewBinding
import com.canerture.connecttotheinternetsample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val productsAdapter by lazy { ProductsAdapter() }

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsAdapter.onProductClick = {
            val action = HomeFragmentDirections.homeToDetail(it)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    homeViewModel.products()
                } else {
                    homeViewModel.searchProduct(newText)
                }
                return false
            }
        })

        homeViewModel.productList.observe(viewLifecycleOwner) {
            if (it != null) {
                productsAdapter.submitList(it)
                binding.rvProducts.adapter = productsAdapter
            } else {
                Toast.makeText(requireContext(), "Empty List!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}