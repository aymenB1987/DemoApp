package com.example.data.datasource.local.dao

import androidx.room.*
import com.example.data.common.util.USERS_LIST_TABLE_NAME
import com.example.data.common.util.USER_TABLE_NAME
import com.example.data.datasource.local.database.UserEntity
import com.example.data.model.UserModel

/**
 * Dao
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
@Dao
interface UserDao {
    @Transaction
    suspend fun updateUserAndReturn(user: UserEntity): UserEntity {
        insertUsers(user)
        return getAllUsers()
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users:UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:UserModel)

    @Query(value = "SELECT * FROM $USERS_LIST_TABLE_NAME  ")
    fun getAllUsers() : UserEntity


}