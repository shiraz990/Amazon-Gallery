package com.shiraz.amazonawslisting.presentation.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.domain.state.DataState
import com.shiraz.amazonawslisting.network.interactor.GetItemResult
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class ListingViewModel
@ViewModelInject
constructor(
    private val getItemResult: GetItemResult
) : ViewModel() {


    // Result data itemResults  MutableLiveData
    private val _dataState: MutableLiveData<DataState<List<ItemResult>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<ItemResult>>>
        get() = _dataState




    fun setStateEvent(){
        viewModelScope.launch {
                    getItemResult.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)

        }
    }


}
