package com.example.domain.repository

import com.example.domain.model.InPut
import com.example.domain.model.Result
import com.example.domain.model.User
import com.example.domain.use_case.GetListUser

/**
 * ListUserRepository
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */

class GetListUserImpl(private val userRepository: ListUserRepository):GetListUser {
    override suspend fun invoke(inPut: InPut): Result<List<User>> = userRepository.getListUser(inPut)
}