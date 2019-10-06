package com.tertychnyi.alex.amconsofttest.usecases.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.converter.RoomConverter
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.dao.UserDao
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.AddressEntity
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.CompanyEntity
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.GeoEntity
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity

@Database(entities = [UserEntity::class, GeoEntity::class, CompanyEntity::class, AddressEntity::class], version = 1)
@TypeConverters(RoomConverter::class)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}