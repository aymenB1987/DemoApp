package com.example.domain.model
/**
 * LoginUserEntity
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
data class LoginUser (val uuid:String, val username:String, val password:String,
                      val salt:String, val md5:String, val sha1:String, val sha256:String )