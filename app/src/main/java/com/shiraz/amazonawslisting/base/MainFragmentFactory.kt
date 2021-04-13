package com.shiraz.amazonawslisting.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.shiraz.amazonawslisting.presentation.ui.list.ListFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainFragmentFactory
@Inject
constructor(
    private val someString: String
): FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {

            ListFragment::class.java.name -> {
                val fragment = ListFragment()
                fragment
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}