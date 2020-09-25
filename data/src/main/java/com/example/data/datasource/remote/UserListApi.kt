package com.example.data.datasource.remote

import com.example.data.model.UsersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Api call users
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
interface UserListApi {

    @GET("api")
    suspend fun getUserList(@Query("page") page: Int,
                            @Query("results") results: Int,
                            @Query("seed") seed: String): Response<UsersListResponse>
}