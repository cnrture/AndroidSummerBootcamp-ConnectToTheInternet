package com.canerture.connecttotheinternetsample.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.canerture.connecttotheinternetsample.data.model.Product
import com.canerture.connecttotheinternetsample.databinding.ItemProductBinding

class ProductsAdapter :
    ListAdapter<Product, ProductsAdapter.ProductViewHolder>(ProductDiffUtilCallback) {

    var onProductClick: (Product) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, onProductClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(currentList[position])

    class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val onProductClick: (Product) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {

            with(binding) {
                tvTitle.text = product.title
                tvPrice.text = "${product.price} ₺"
                Glide.with(binding.imgProduct).load(product.image).into(binding.imgProduct)

                root.setOnClickListener { onProductClick(product) }
            }
        }
    }
}

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
}