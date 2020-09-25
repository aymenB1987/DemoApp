package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.common.util.DomainMapper
import com.example.data.common.util.USER_TABLE_NAME
import com.example.domain.model.*

/**
 * UserModel
 * Aymen Bouali
 * Coyote
 * @date 19/09/2020
 */
@Entity(tableName = USER_TABLE_NAME)
data class UserModel (@PrimaryKey(autoGenerate = true)
                      val id_user : Int? = 0,
                      val gender: String? = "",
                      val name: NameUserModel?,
                      val location: LocationUserModel?,
                      val email: String? = "",
                      val login: LoginUserModel?,
                      val dob: DobUserModel?,
                      val registered: RegisteredUserModel?,
                      val phone: String? = "",
                      val cell: String? = "",
                      val id: IdUserModel?,
                      val picture: PictureUserModel?,
                      val nat: String? = ""): DomainMapper<User> {
    override fun mapToDomainModel() = User(gender?:"", NameUser(title = name?.title?:"",first = name?.first?:"",last = name?.last?:""),LocationUser(
        StreetLocation(location?.street?.number?:0,location?.street?.name?:""),location?.city?:"",location?.state?:"",
        location?.country?:"",location?.postcode?:"",
        CoordinatesLocation(location?.coordinates?.latitude?:0.0,location?.coordinates?.longitude?:0.0),
        TimeZoneLocation(location?.timezone?.offset?:"",location?.timezone?.description?:"")),email?:"",LoginUser(login?.uuid?:"",login?.username?:"",
        login?.password?:"",login?.salt?:"",login?.md5?:""
        ,login?.sha1?:"",login?.sha256?:""),DobUser(dob?.date_dob?:"",dob?.age_dob?:0),RegisteredUser(registered?.date_reg?:"",registered?.age_reg?:0),
            phone?:"",cell?:"",IdUser(id?.name?:"",id?.value?:""),PictureUser(picture?.large?:"",picture?.medium?:"",picture?.thumbnail?:"") ,
        nat?:"")
}

@Entity
data class CoordinatesLocationModel(val latitude:Double?=0.0, val longitude:Double?=0.0):DomainMapper<CoordinatesLocation> {
    override fun mapToDomainModel() = CoordinatesLocation(latitude?:0.0,longitude?:0.0)
}

@Entity
data class DobUserModel(val date_dob :String ? = "",
                   val age_dob :Int? = 0):DomainMapper<DobUser> {
    override fun mapToDomainModel()= DobUser(date_dob?:"",age_dob?:0)
}

@Entity
data class IdUserModel (val name :String? = "",
                   val value :String? = ""):DomainMapper<IdUser> {
    override fun mapToDomainModel()= IdUser(name?:"",value?:"")

}

@Entity
data class LocationUserModel (
                              val street:StreetLocationModel?,
                         val city:String? = "",
                         val state:String? = "",
                         val country:String? = "",
                         val postcode:String? = "0",
                         val coordinates: CoordinatesLocationModel?,
                         val timezone:TimeZoneLocationModel?):DomainMapper<LocationUser> {
    override fun mapToDomainModel()= LocationUser(
        StreetLocation(street?.number?:0,street?.name?:""),city?:"",state?:"",
                                                                    country?:"",postcode?:"",
        CoordinatesLocation(coordinates?.latitude?:0.0,coordinates?.longitude?:0.0),
        TimeZoneLocation(timezone?.offset?:"",timezone?.description?:"")
    )
}

@Entity
data class LoginUserModel (
                           val uuid:String? = "", val username:String? = "", val password:String? = "",
                      val salt:String? = "", val md5:String? = "", val sha1:String? = "", val sha256:String? = "" ):DomainMapper<LoginUser> {
    override fun mapToDomainModel() = LoginUser(uuid?:"",username?:"",password?:"",salt?:"",md5?:""
                                                        ,sha1?:"",sha256?:"")
}

data class NameUserModel (val title: String? = "" ,
                          val first:String? = "",
                          val last:String? = ""):DomainMapper<NameUser> {
    override fun mapToDomainModel()= NameUser (title?:"",first?:"",last?:"")
}

@Entity
data class PictureUserModel(val large:String? = "", val medium:String? = "", val thumbnail:String? = ""):DomainMapper<PictureUser> {
    override fun mapToDomainModel()= PictureUser(large?:"",medium?:"",thumbnail?:"")
}

@Entity
data class RegisteredUserModel (
    val date_reg:String? = "",
    val age_reg:Int? = 0):DomainMapper<RegisteredUser> {
    override fun mapToDomainModel()= RegisteredUser(date_reg?:"",age_reg?:0)
}

@Entity
data class StreetLocationModel (val number:Int? = 0,
                           val name:String? = ""):DomainMapper<StreetLocation> {
    override fun mapToDomainModel()= StreetLocation(number?:0,name?:"")
}

@Entity
data class TimeZoneLocationModel (val offset:String?="",val description:String? = ""):DomainMapper<TimeZoneLocation> {
    override fun mapToDomainModel()= TimeZoneLocation(offset?:"",description?:"")
}