package com.dashkevich.utility.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<I : Item>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(item: I)

}