package com.example.demoapp.routing

import androidx.fragment.app.FragmentActivity
import com.example.demoapp.R
import com.example.demoapp.common.showFragment
import com.example.demoapp.ui.users.view.DetailUserFragment
import com.example.domain.model.User


/**
 * FragmentNavigator
 * Aymen Bouali
 * Coyote
 * @date 23/09/2020
 */

/**
 * Every activity that holds fragments should name its container "fragmentContainer"
 */

class AppFragmentNavigator(private val activity: FragmentActivity) : FragmentNavigator {

    override fun showUserDetails(user:User) = activity.showFragment(DetailUserFragment.newInstance(user), R.id.fragmentContainer, true)

}

