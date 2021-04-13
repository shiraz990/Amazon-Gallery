package com.shiraz.amazonawslisting.presentation.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.shiraz.amazonawslisting.R
import com.shiraz.amazonawslisting.base.BaseListAdapter
import com.shiraz.amazonawslisting.databinding.ItemResultBinding
import com.shiraz.amazonawslisting.domain.model.ItemResult

class GalleryListingAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val clickDetailListener: (item: ItemResult) -> Unit
) : BaseListAdapter<ItemResult, ItemResultBinding>(
    diffCallback = diffCallback
) {


    override fun createBinding(parent: ViewGroup, viewType: Int): ItemResultBinding {
        val binding = DataBindingUtil.inflate<ItemResultBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_result,
            parent,
            false,
            dataBindingComponent
        )

        return binding
    }

    override fun bind(binding: ItemResultBinding, item: ItemResult, position: Int) {
        binding.result = item
        binding.root.setOnClickListener {
            clickDetailListener(getItem(position))
        }

    }


}

private val diffCallback: DiffUtil.ItemCallback<ItemResult> =
    object : DiffUtil.ItemCallback<ItemResult>() {
        override fun areItemsTheSame(oldItem: ItemResult, newItem: ItemResult): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: ItemResult, newItem: ItemResult): Boolean {
            return oldItem.image_ids == newItem.image_ids
        }
    }
