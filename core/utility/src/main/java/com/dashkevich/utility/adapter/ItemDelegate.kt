package com.dashkevich.utility.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

interface ItemDelegate {

    fun isRelativeItem(item: Item): Boolean

    @LayoutRes
    fun getLayoutId(): Int

    fun createViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
    ): BaseViewHolder<*>


}