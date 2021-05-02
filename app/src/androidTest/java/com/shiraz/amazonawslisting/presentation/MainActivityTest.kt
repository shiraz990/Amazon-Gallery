/*
package com.shiraz.amazonawslisting.presentation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.shiraz.amazonawslisting.HiltTestRunner
import com.shiraz.amazonawslisting.R
import com.shiraz.amazonawslisting.di.NetworkModule
import com.shiraz.amazonawslisting.util.FileReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(NetworkModule::class)
@HiltAndroidTest
class MainActivityTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    private lateinit var mockServer: MockWebServer

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        mockServer.start(8080)
    }

    @After
    fun tearDown() =
        mockServer.shutdown()

    @Test
    fun happyTestCase() {
        mockServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(FileReader.readStringFromFile("success_response.json"))
            }
        }
        activityRule.launchActivity(null)
        Espresso.onView(withId(R.id.progress_bar)).run {
            check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
        }
        Espresso.onView(withId(R.id.rv_gallery)).run {
            check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun unHappyTestCase() {
        mockServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().throttleBody(1024, 5, TimeUnit.SECONDS)
            }
        }
        activityRule.launchActivity(null)

    }
}*/
