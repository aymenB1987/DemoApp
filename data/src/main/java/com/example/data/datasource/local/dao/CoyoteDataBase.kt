package com.example.data.datasource.local.dao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.datasource.local.database.UserEntity
import com.example.data.datasource.local.util.Converters
import com.example.data.model.*

/**
 * Database
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
@Database(entities = arrayOf(UserEntity::class,UserModel::class), version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class CoyoteDataBase : RoomDatabase() {

    abstract fun userDao():UserDao
}