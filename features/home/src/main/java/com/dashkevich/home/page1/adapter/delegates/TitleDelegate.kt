package com.dashkevich.home.page1.adapter.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.model.Title
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate


class TitleDelegate() : ItemDelegate {

    override fun isRelativeItem(item: Item): Boolean = item is Title

    override fun getLayoutId(): Int = R.layout.title_item

    override fun createViewHolder(
        layoutInflater:
        LayoutInflater, parent: ViewGroup)
    : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.title_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : BaseViewHolder<Title>(view) {
        val text: TextView = view.findViewById(R.id.text)

        val layoutParams = view.layoutParams as MarginLayoutParams

        override fun onBind(item: Title) {
            text.text = item.text
            layoutParams.topMargin = item.margin
        }
    }


}