package com.example.data.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.datasource.local.dao.CoyoteDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Depencencuy inejction DB
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
private const val USER_DB = "user-database"

val databaseModule = module {
  single {
    //TODO remove fallbackToDestructiveMigration when this goes to production
    Room.databaseBuilder(androidContext(), CoyoteDataBase::class.java, USER_DB).fallbackToDestructiveMigration().build()
  }
  factory { get<CoyoteDataBase>().userDao() }
}