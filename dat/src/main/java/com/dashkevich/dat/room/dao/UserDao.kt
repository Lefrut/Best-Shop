package com.dashkevich.dat.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dashkevich.dat.room.entity.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUsers(vararg users: User)

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT email FROM user WHERE email LIKE :uEmail LIMIT 1")
    fun findUser(uEmail: String): Flow<String>
}