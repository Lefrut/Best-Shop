package com.dashkevich.utility.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface ItemDelegate {

    fun isRelativeItem(item: Item): Boolean

    @LayoutRes
    fun getLayoutId(): Int

    fun getViewHolder(
        context: Context,
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        item: Item
    ) : View
}
