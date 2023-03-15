package com.dashkevich.home.page1.adapter.delegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.Adapter
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.home.page1.adapter.model.Title
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate

class HorizontalItemsDelegate(
    private val itemsDelegate: List<ItemDelegate>
) : ItemDelegate {
    override fun isRelativeItem(item: Item): Boolean = item is LatestUI

    override fun getLayoutId(): Int = R.layout.horizontal_item
    override fun createViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_item, parent, false)
        return ViewHolder(view, itemsDelegate)
    }

    class ViewHolder(
        view: View, itemsDelegate: List<ItemDelegate>
    ) : BaseViewHolder<Title>(view) {

        val adapter = Adapter(itemsDelegate)

        override fun onBind(item: Title) {
        }
    }
}