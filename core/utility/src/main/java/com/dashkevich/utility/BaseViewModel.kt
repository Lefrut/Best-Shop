package com.dashkevich.utility

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewModel<out V: ViewBinding, in I: Item>(
        val binding: V
    ) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: I)

}