package com.example.data.di

import com.example.data.common.utils.Connectivity
import com.example.data.common.utils.ConnectivityImpl
import com.example.data.repository.ListUserRepositoryImpl
import com.example.domain.repository.ListUserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Depencencuy inejction Repository
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
val repositoryModule = module {
  factory<ListUserRepository> { ListUserRepositoryImpl(get(), get()) }
  factory<Connectivity> { ConnectivityImpl(androidContext()) }
}