package com.canerture.connecttotheinternetsample.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.canerture.connecttotheinternetsample.R
import com.canerture.connecttotheinternetsample.common.viewBinding
import com.canerture.connecttotheinternetsample.databinding.FragmentDetailBinding
import com.canerture.connecttotheinternetsample.databinding.FragmentHomeBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            args.product.let {

                tvTitle.text = it.title
                tvPrice.text = "${it.price} ₺"
                tvDescription.text = it.description
                Glide.with(imgProduct).load(it.image).into(imgProduct)
            }
        }
    }
}