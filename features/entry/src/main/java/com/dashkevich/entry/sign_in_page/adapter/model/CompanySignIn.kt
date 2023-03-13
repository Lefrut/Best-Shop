package com.dashkevich.entry.sign_in_page.adapter.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class CompanySignIn(
    @DrawableRes
    val icon: Int,
    @StringRes
    val text: Int,
    val iconMarginEnd: Int
) : Item