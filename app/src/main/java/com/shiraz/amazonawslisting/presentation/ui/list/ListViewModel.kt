package com.shiraz.amazonawslisting.presentation.ui.list

import androidx.lifecycle.*
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.daggerhiltplayground.business.domain.state.DataState
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.network.interactor.GetItemResult
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch




class ListViewModel
@ViewModelInject
constructor(
    private val getItemResult: GetItemResult,
    @Assisted private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    // Result data itemResults  MutableLiveData
    private val _dataState: MutableLiveData<DataState<List<ItemResult>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<ItemResult>>>
        get() = _dataState




    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetItemResultEvent -> {
                    getItemResult.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

}


sealed class MainStateEvent{

    object GetItemResultEvent: MainStateEvent()

    object None: MainStateEvent()
}
















