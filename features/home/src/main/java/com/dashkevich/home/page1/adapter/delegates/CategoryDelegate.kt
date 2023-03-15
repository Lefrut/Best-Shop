package com.dashkevich.home.page1.adapter.delegates

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.model.Category
import com.dashkevich.home.page1.adapter.model.FlashSaleUI
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate

class CategoryDelegate : ItemDelegate {

    override fun isRelativeItem(item: Item): Boolean = item is Category

    override fun getLayoutId(): Int = R.layout.category_item

    override fun createViewHolder(
        layoutInflater:
        LayoutInflater, parent: ViewGroup
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : BaseViewHolder<Category>(view) {
        private val icon: ImageView = view.findViewById(R.id.category_icon)
        private val title: TextView = view.findViewById(R.id.category_title)


        @SuppressLint("SetTextI18n")
        override fun onBind(item: Category) {
            title.text = item.title
            icon.setImageResource(item.icon)
        }
    }


}