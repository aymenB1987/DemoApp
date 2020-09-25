package com.example.data.model

import com.example.data.common.util.RoomMapper
import com.example.data.datasource.local.database.UserEntity

/**
 * ResponseApiModel
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
data class UsersListResponse(val id: Int? = 0,
                             val results : List<UserModel>?,
                             val info : ResponseInfo?) : RoomMapper<UserEntity> {

    override fun mapToRoomEntity() = UserEntity(id,info ?: ResponseInfo("",0,0),results ?: arrayListOf())
}