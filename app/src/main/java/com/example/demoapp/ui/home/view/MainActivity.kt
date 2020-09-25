package com.example.demoapp.ui.home.view

import android.os.Bundle
import com.example.demoapp.R
import com.example.demoapp.routing.AppNavigator
import com.example.demoapp.routing.ScreenType
import com.example.demoapp.ui.base.BaseActivity
import com.example.demoapp.ui.users.view.UserListFragment

/**
 * MainActivity
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(UserListFragment.newInstance(),R.id.fragmentContainer,true)

    }


}