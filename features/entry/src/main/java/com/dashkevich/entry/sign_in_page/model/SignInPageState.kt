package com.dashkevich.entry.sign_in_page.model

data class SignInPageState(
    val haveUser: HaveUser = HaveUser.Clear,
)


enum class HaveUser {
    Clear, Yes, No
}


