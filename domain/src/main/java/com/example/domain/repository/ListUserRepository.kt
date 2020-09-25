package com.example.domain.repository

import com.example.domain.model.InPut
import com.example.domain.model.Result
import com.example.domain.model.User

/**
 * ListUserRepository
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
interface ListUserRepository {
        suspend fun getListUser(inPut: InPut): Result<List<User>>
}