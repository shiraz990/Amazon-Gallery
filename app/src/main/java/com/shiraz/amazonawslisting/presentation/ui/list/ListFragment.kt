package com.shiraz.amazonawslisting.presentation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithmitch.daggerhiltplayground.business.domain.state.DataState
import com.shiraz.amazonawslisting.R
import com.shiraz.amazonawslisting.base.MyDataBindingComponent
import com.shiraz.amazonawslisting.databinding.FragmentFirstBinding
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.presentation.BaseApplication
import com.shiraz.amazonawslisting.presentation.ui.list.adapter.GalleryListingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.StringBuilder
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ListFragment : Fragment() {


    @Inject
    lateinit var application: BaseApplication
    private val viewModel: ListViewModel by viewModels()
    private var dataBindingComponent = MyDataBindingComponent(this)
    private lateinit var binding: FragmentFirstBinding
    private lateinit var galleryListingAdapter: GalleryListingAdapter


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, null, false)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // API trigger
        viewModel.setStateEvent(MainStateEvent.GetItemResultEvent)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Intializing adapter
        setupRecyclerView()
        //LiveData observer
        subscribeObservers()
    }


    private fun setupRecyclerView() {
        galleryListingAdapter = GalleryListingAdapter(dataBindingComponent){
            //Navigating to detail screen
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }
        binding.rvGallery.adapter = galleryListingAdapter
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<ItemResult>> -> {
                    displayProgressBar(false)
                    galleryListingAdapter.submitList(dataState.data)

                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }



    private fun displayError(message: String?){
        binding.tvPlaceholder.visibility=View.VISIBLE
        if(message != null) binding.tvPlaceholder.text= message else binding.tvPlaceholder.text = "Unknown error."
    }
    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }

}