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
    suspend fun insertUsers(vararg users: User)

    @Query("SELECT * FROM user")
    fun selectUsers(): Flow<List<User>>

    @Query("SELECT email FROM user WHERE email LIKE :uEmail LIMIT 1")
    fun findEmail(uEmail: String): Flow<String?>

    @Query("SELECT * FROM user " +
            "WHERE password LIKE :password AND first_name LIKE :firstName" +
            " LIMIT 1")
    fun findUser(firstName: String, password: String): Flow<User?>

}