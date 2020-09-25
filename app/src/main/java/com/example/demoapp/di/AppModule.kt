package com.example.demoapp.di
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.data.common.couroutine.CoroutineContextProvider
import com.example.demoapp.routing.AppFragmentNavigator
import com.example.demoapp.routing.AppNavigator
import org.koin.dsl.module

/**
 * Depencencuy inejction Module
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
val appModule = module {
  single { CoroutineContextProvider() }
  single { (activity: AppCompatActivity) -> AppNavigator(activity) }
  single { (activity: FragmentActivity) -> AppFragmentNavigator(activity) }
}