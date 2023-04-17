package com.p1rat.android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.p1rat.android.data.catalog.NearestRestaurantEntity
import com.p1rat.android.data.catalog.PopularRestaurantEntity
import com.p1rat.android.data.catalog.RestaurantDao


@Database(entities = [NearestRestaurantEntity::class, PopularRestaurantEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}