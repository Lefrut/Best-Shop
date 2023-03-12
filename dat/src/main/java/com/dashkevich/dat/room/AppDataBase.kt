package com.dashkevich.dat.room

import androidx.room.Database
import com.dashkevich.dat.room.dao.UserDao
import com.dashkevich.dat.room.entity.User


@Database(entities = [User::class], version = 1)
abstract class AppDataBase {

    abstract fun userDao(): UserDao

}