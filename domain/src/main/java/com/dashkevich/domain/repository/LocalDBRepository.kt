package com.dashkevich.domain.repository

import com.dashkevich.dat.room.AppDataBase
import com.dashkevich.dat.room.entity.User
import kotlinx.coroutines.flow.*

class LocalDBRepository(private val localDB: AppDataBase) {

    private val userDao = localDB.userDao()

    suspend fun addUser(vararg users: User): Result<Boolean> = kotlin.runCatching {
        userDao.insertUsers(*users)
        return@runCatching true
    }

    fun haveEmail(email: String): Flow<String?> = userDao.findEmail(email)

    fun getUser(firstName: String, password: String) = userDao.findUser(firstName, password)

    suspend fun getUsers(): Result<List<User>> = kotlin.runCatching {
        var value: List<User> = listOf()
        userDao.selectUsers().onEach {
            value = it
        }.collect()
        return@runCatching value
    }

}
