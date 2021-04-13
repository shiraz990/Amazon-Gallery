package com.shiraz.amazonawslisting.presentation.ui.list

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.shiraz.amazonawslisting.R
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.launchFragmentInHiltContainer
import com.shiraz.amazonawslisting.presentation.ui.list.adapter.GalleryListingAdapter
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ListFragmentTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun listScreenFragment(){
        var navController = mock(NavController::class.java)

        launchFragmentInHiltContainer<ListFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }


    }
}