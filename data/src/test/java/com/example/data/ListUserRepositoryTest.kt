package com.example.data

import com.example.data.common.utils.Connectivity
import com.example.data.datasource.local.dao.UserDao
import com.example.data.datasource.remote.UserListApi
import com.example.data.repository.ListUserRepositoryImpl
import com.example.data.utils.*
import com.example.domain.model.InPut
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response

/**
 * ListUserRepositoryTest
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
class ListUserRepositoryTest {
  
  private val userTestApi: UserListApi = mock()
  private val userDao: UserDao = mock()
  private val connectivity: Connectivity = mock()
  private val userRepository = ListUserRepositoryImpl(userTestApi, userDao)
  
  @Test
  fun `test getUser calls api and saves data to db upon success`() {
    runBlocking {
      whenever(connectivity.hasNetworkAccess()).thenReturn(true)
      whenever(userTestApi.getUserList(INPUT.page,INPUT.results,INPUT.seed)).thenReturn(Response.success(successUserInfoResponse))
      whenever(userDao.updateUserAndReturn(successUserInfoResponse.mapToRoomEntity())).thenReturn(fakeUserEntity)
      userRepository.getListUser(INPUT)
      
      verify(userTestApi, times(1)).getUserList(INPUT.page,INPUT.results,INPUT.seed)
      verify(userDao, times(1)).updateUserAndReturn(fakeUserEntity)
    }
  }
  
  @Test
  fun `test getUser calls api and returns cached data from db upon failure`() {
    runBlocking {
      whenever(connectivity.hasNetworkAccess()).thenReturn(true)
      whenever(userTestApi.getUserList(INPUT.page,INPUT.results,INPUT.seed))
          .thenReturn(Response.error(FAKE_FAILURE_ERROR_CODE, failureResponseBody))
      userRepository.getListUser(INPUT)
      
      verify(userTestApi, times(1)).getUserList(INPUT.page,INPUT.results,INPUT.seed)
      verify(userDao, never()).updateUserAndReturn(fakeUserEntity)
    }
  }
}