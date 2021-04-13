package com.shiraz.amazonawslisting.presentation.ui.list

import org.junit.Assert.*


@ExperimentalCoroutinesApi
class ListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ListViewModel

    @Before
    fun setup() {
        viewModel = ListViewModel()
    }


}
