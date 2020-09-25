package com.example.data.datasource.local.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.data.common.util.DomainMapper
import com.example.data.common.util.USERS_LIST_TABLE_NAME
import com.example.data.model.ResponseInfo
import com.example.data.model.UserModel
import com.example.domain.model.User

/**
 * Table ilst users
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
@Entity(tableName = USERS_LIST_TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val info: ResponseInfo?,
    val results: List<UserModel>):DomainMapper<List<User>> {
    override fun mapToDomainModel(): List<User> {
        val users : ArrayList<User> = arrayListOf()
        for (user in results) {
            users.add(user.mapToDomainModel())
        }
        return users
    }

}