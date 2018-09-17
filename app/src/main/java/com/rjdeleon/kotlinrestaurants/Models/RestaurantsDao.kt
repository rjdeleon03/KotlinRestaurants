package com.rjdeleon.kotlinrestaurants.Models

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface RestaurantsDao {

    @Query("SELECT * FROM restaurant")
    fun queryRestaurants() : LiveData<List<Restaurant>>

    @Query("SELECT * FROM restaurant WHERE cuisine LIKE :cuisine")
    fun queryRestarantsByCuisine(cuisine: Int): LiveData<List<Restaurant>>

    @Insert(onConflict = REPLACE)
    fun insertRestaurant(restaurant : Restaurant)
}