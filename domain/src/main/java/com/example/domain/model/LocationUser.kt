package com.example.domain.model

/**
 * LocationUserEntity
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */


data class LocationUser (val street:StreetLocation,
                         val city:String,
                         val state:String,
                         val country:String,
                         val postcode:String,
                         val coordinates:CoordinatesLocation,
                         val timezone:TimeZoneLocation)