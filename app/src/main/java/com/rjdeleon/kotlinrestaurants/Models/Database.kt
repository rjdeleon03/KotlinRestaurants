package com.rjdeleon.kotlinrestaurants.Models

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Restaurant::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun restaurantsDao() : RestaurantsDao
}