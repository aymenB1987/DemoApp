package com.example.data.datasource.local.util

import androidx.room.TypeConverter
import com.example.data.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Converters utlils
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
class Converters {
  private val gson = Gson()

  // User list converters

  @TypeConverter
  fun fromUserEntityListToJson(list: List<UserModel>?): String {
    return list?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToList(jsonList: String): List<UserModel>? {
    val listType = object : TypeToken<List<UserModel>>() {}.type
    return gson.fromJson(jsonList, listType)
  }


  // ResponseInfo converters
  
  @TypeConverter
  fun fromInfoToJson(mainInfo: ResponseInfo?): String {
    return mainInfo?.let { gson.toJson(it) } ?: ""
  }
  
  @TypeConverter
  fun fromJsonToInfo(json: String): ResponseInfo {
    val type = object : TypeToken<ResponseInfo>() {}.type
    return gson.fromJson(json, type)
  }
  // UserModel converters

  @TypeConverter
  fun fromUserToJson(user: UserModel?): String {
    return user?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToUser(json: String): UserModel {
    val type = object : TypeToken<UserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // LocationUserModel converters

  @TypeConverter
  fun fromUserToJson(userLocation: LocationUserModel?): String {
    return userLocation?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToLocationUser(json: String): LocationUserModel {
    val type = object : TypeToken<LocationUserModel>() {}.type
    return gson.fromJson(json, type)
  }

  // LoginUserModel converters

  @TypeConverter
  fun fromLoginUserToJson(userLoginUser: LoginUserModel?): String {
    return userLoginUser?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToLoginUser(json: String): LoginUserModel {
    val type = object : TypeToken<LoginUserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // DobUserModel converters

  @TypeConverter
  fun fromDobUserToJson(userDob: DobUserModel?): String {
    return userDob?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToDobUser(json: String): DobUserModel {
    val type = object : TypeToken<DobUserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // RegisteredUserModel converters

  @TypeConverter
  fun fromRegisteredUserToJson(userRegisteredUser: RegisteredUserModel?): String {
    return userRegisteredUser?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToRegisteredUser(json: String): RegisteredUserModel {
    val type = object : TypeToken<RegisteredUserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // IdUserModell converters

  @TypeConverter
  fun fromIdUserToJson(userId: IdUserModel?): String {
    return userId?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToIUser(json: String): IdUserModel {
    val type = object : TypeToken<IdUserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // LoginUserModelUserModel converters

  @TypeConverter
  fun fromPictureUserToJson(userPictureUser: PictureUserModel?): String {
    return userPictureUser?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToPictureUser(json: String): PictureUserModel {
    val type = object : TypeToken<PictureUserModel>() {}.type
    return gson.fromJson(json, type)
  }

  // StreetLocationModel converters

  @TypeConverter
  fun fromStreetLocationToJson(userStreetLocation: StreetLocationModel?): String {
    return userStreetLocation?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToStreetLocation(json: String): StreetLocationModel {
    val type = object : TypeToken<StreetLocationModel>() {}.type
    return gson.fromJson(json, type)
  }
  // CoordinatesLocationModel converters

  @TypeConverter
  fun fromCoordinatesLocationToJson(userCoordinatesLocation: CoordinatesLocationModel?): String {
    return userCoordinatesLocation?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToCoordinatesLocation(json: String): CoordinatesLocationModel {
    val type = object : TypeToken<CoordinatesLocationModel>() {}.type
    return gson.fromJson(json, type)
  }

  // NameUserModel converters
  @TypeConverter
  fun fromNameUserToJson(userNameUser: NameUserModel?): String {
    return userNameUser?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToNameUser(json: String): NameUserModel {
    val type = object : TypeToken<NameUserModel>() {}.type
    return gson.fromJson(json, type)
  }
  // TimeZoneLocationModel converters

  @TypeConverter
  fun fromTimeZoneLocationToJson(userTimeZoneLocation: TimeZoneLocationModel?): String {
    return userTimeZoneLocation?.let { gson.toJson(it) } ?: ""
  }

  @TypeConverter
  fun fromJsonToTimeZoneLocation(json: String): TimeZoneLocationModel {
    val type = object : TypeToken<TimeZoneLocationModel>() {}.type
    return gson.fromJson(json, type)
  }
}