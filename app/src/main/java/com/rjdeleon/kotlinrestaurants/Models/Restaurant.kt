package com.rjdeleon.kotlinrestaurants.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Restaurant(@PrimaryKey val id: Int, val cuisine: Int?, val name: String?,
                      val lat: Double, val lng: Double, val price: Int,
                      val image: String = "", val description: String = "") : Serializable