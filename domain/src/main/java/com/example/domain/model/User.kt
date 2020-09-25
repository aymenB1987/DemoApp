package com.example.domain.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


/**
 * UserEntity
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
data class User (
 val gender: String,
 val name: NameUser,
 val location: LocationUser,
 val email: String,
 val login: LoginUser,
 val dob: DobUser,
 val registered: RegisteredUser,
 val phone: String,
 val cell: String,
 val id: IdUser,
 val picture: PictureUser,
 val nat: String
) : Serializable