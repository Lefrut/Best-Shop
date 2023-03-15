package com.dashkevich.entry.login.model

import com.dashkevich.dat.room.entity.User
import com.dashkevich.entry.sign_in_page.model.HaveUser

data class LoginState(
    val loginUser: HaveUser = HaveUser.Clear,
    val user: User = User(0, "", "", "", "")
)
