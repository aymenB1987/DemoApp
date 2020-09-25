package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * ResponseModel
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
@Entity
data class ResponseInfo(val seed :String ? = "",
                        val results: Int? = 0,
                        val page: Int? = 0,
                        val version: String? ="")