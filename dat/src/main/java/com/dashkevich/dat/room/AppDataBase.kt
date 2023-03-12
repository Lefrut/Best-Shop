package com.dashkevich.dat.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.dashkevich.dat.room.dao.UserDao
import com.dashkevich.dat.room.entity.User


@Database(
    entities = [User::class], version = 1, exportSchema = false
)
abstract class AppDataBase() : RoomDatabase() {

    abstract fun userDao(): UserDao

}