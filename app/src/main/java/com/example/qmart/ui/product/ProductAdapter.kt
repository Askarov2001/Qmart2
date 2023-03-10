package com.example.qmart.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.qmart.data.OrderType
import com.example.qmart.data.Product
import com.example.qmart.databinding.ItemOrderTypeBinding
import com.example.qmart.databinding.ItemProductBinding

class ProductAdapter : ListAdapter<Product, TypeViewHolder>(ProductDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)

        return TypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val product = getItem(position)

        with(holder.binding) {
            productTitleTextView.text = product.name
            productCostTextView.text = String.format("%d kzt", product.cost)
            productImageView.setImageURI(product.productImage1)
        }
    }
}

class TypeViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)



class ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}