package com.example.data.utils

import com.example.data.datasource.local.database.UserEntity
import com.example.data.model.ResponseInfo
import com.example.data.model.UsersListResponse
import com.example.domain.model.InPut
import okhttp3.MediaType
import okhttp3.ResponseBody

val  INPUT = InPut(1,10,"a")
const val FAKE_FAILURE_ERROR_CODE = 400

val successUserInfoResponse = UsersListResponse(arrayListOf(), ResponseInfo())
val failureResponseBody = ResponseBody.create(MediaType.parse("text"), "network error")
val fakeUserEntity = UserEntity(0,ResponseInfo(), arrayListOf() )
