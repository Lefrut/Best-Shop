package com.dashkevich.profile.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dashkevich.profile.R
import com.dashkevich.utility.adapter.Item

class ProfileItem(
    @DrawableRes
    val icon: Int,
    @StringRes
    val text: Int,
    val marginEnd: Int,
    val haveArrow: Boolean = false,
    val haveMoney: Boolean = false,
    val money: Float = 0f,
    val onClick: () -> Unit = {}
) : Item {
    companion object {
        val baseItems = listOf(
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.credit_card,
                text = com.dashkevich.ui.R.string.trade_store,
                marginEnd = 45,
                haveArrow = true,
                haveMoney = false
            ),
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.credit_card,
                text = com.dashkevich.ui.R.string.payment_method,
                marginEnd = 45,
                haveArrow = true,
                haveMoney = false
            ),
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.credit_card,
                text = com.dashkevich.ui.R.string.balance,
                marginEnd = 31,
                haveMoney = true,
                money = 1593f,
            ),
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.credit_card,
                text = com.dashkevich.ui.R.string.trade_history,
                marginEnd = 47,
                haveArrow = true,
                ),
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.refresh,
                text = com.dashkevich.ui.R.string.restore_purchase,
                marginEnd = 46,
                haveArrow = true,
            ),
            ProfileItem(
                icon = com.dashkevich.ui.R.drawable.help,
                text = com.dashkevich.ui.R.string.help,
                marginEnd = 45,
            )
        )
    }

}