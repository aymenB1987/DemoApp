package com.example.data.repository


import com.example.data.common.base.BaseRepository
import com.example.data.common.util.getData
import com.example.data.datasource.local.dao.UserDao
import com.example.data.datasource.local.database.UserEntity
import com.example.data.datasource.remote.UserListApi
import com.example.data.model.ResponseInfo
import com.example.domain.model.InPut
import com.example.domain.model.Result
import com.example.domain.model.User
import com.example.domain.repository.ListUserRepository

/**
 * ListUserRepository
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
class ListUserRepositoryImpl(private val userResponseApi: UserListApi,
                             private val userDao: UserDao) : BaseRepository<List<User>, UserEntity>(), ListUserRepository {



    override suspend fun getListUser(inPut: InPut): Result<List<User>> {
        return fetchData(
            apiDataProvider = {
                userResponseApi.getUserList(inPut.page,inPut.results,inPut.seed).getData(
                    fetchFromCacheAction = { userDao.getAllUsers()},
                    cacheAction = { userDao.insertUsers(it) }
                      )
            },
            dbDataProvider = { userDao.getAllUsers() }
        )
    }

}