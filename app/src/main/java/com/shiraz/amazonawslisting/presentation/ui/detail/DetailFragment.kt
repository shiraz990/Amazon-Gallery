package com.shiraz.amazonawslisting.presentation.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.shiraz.amazonawslisting.R
import com.shiraz.amazonawslisting.databinding.FragmentSecondBinding
import com.shiraz.amazonawslisting.domain.model.ItemResult

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding
    private val args by navArgs<DetailFragmentArgs>()
    lateinit var itemResult: ItemResult
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        if (!this::binding.isInitialized) {
            binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_second, null, false)
        }

        // Argument set
        itemResult = args.resultItem
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.result = itemResult
        Glide.with(this).load(itemResult.image_urls)
            .skipMemoryCache(true)
            .placeholder(R.drawable.progress_animation)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                     return false; // important to return false so the error placeholder can be placed

                }


                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false; // important to return false so the error placeholder can be placed

                }
            })
            .into(binding.detailImage)
    }
}