package com.example.domain

import com.example.domain.model.InPut
import com.example.domain.repository.GetListUserImpl
import com.example.domain.repository.ListUserRepository
import com.example.domain.use_case.GetListUser
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * GetListUserTest
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
class GetListUserTest {

    private val userRepository: ListUserRepository = mock()
    private val getUsers by lazy { GetListUserImpl(userRepository) }
    private val inPut = InPut(1,10,"a")
    @Test
    fun `test GetUsersUseCase calls UserListRepository`() {
        runBlocking {
            getUsers(inPut)
            verify(userRepository).getListUser(inPut)
        }
    }
}