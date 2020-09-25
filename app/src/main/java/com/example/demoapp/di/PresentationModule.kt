package com.example.demoapp.di
import androidx.lifecycle.SavedStateHandle
import com.example.demoapp.ui.users.mv.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Depencency inejction ViewModel
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
val presentationModule = module {
  viewModel { UsersViewModel(get()) }
}