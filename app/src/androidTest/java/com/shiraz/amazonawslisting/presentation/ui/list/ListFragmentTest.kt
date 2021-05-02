package com.shiraz.amazonawslisting.presentation.ui.list

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.shiraz.amazonawslisting.domain.model.ItemResult
import com.shiraz.amazonawslisting.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ListFragmentTest{
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun click_navigateToListFragment() {
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<ListFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }


    }
}