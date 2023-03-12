package com.dashkevich.domain.repository

import com.dashkevich.dat.room.AppDataBase
import com.dashkevich.dat.room.entity.User
import kotlinx.coroutines.flow.catch

class LocalDBRepository(private val localDB: AppDataBase) {

    private val userDao = localDB.userDao()

    suspend fun addUser(vararg users: User): Result<Unit> = kotlin.runCatching {
        userDao.insertUsers(*users)
    }

    suspend fun haveUser(email: String) = kotlin.runCatching {
        var value: String? = ""
        userDao.findUser(email).collect{
            value = it
        }
        return@runCatching !value.isNullOrEmpty()
    }

    suspend fun getUsers(): Result<List<User>> = kotlin.runCatching {
        var value: List<User> = listOf()
        userDao.selectUsers().collect{
            value = it
        }
        return@runCatching value
    }

}