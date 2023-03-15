package com.dashkevich.home.page1.adapter.delegates

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.Adapter
import com.dashkevich.home.page1.adapter.model.HorizontalItems
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.home.page1.adapter.model.Title
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate

class HorizontalItemsDelegate(
    private val itemsDelegate: List<ItemDelegate>
) : ItemDelegate {
    override fun isRelativeItem(item: Item): Boolean = item is HorizontalItems

    override fun getLayoutId(): Int = R.layout.horizontal_item
    override fun createViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_item, parent, false)
        return ViewHolder(view, itemsDelegate, parent.context)
    }

    class ViewHolder(
        view: View, itemsDelegate: List<ItemDelegate>, val context: Context
    ) : BaseViewHolder<HorizontalItems>(view) {

        val adapter = Adapter(itemsDelegate)
        private val recyclerView: RecyclerView = view.findViewById(R.id.horizontal_rv)

        override fun onBind(item: HorizontalItems) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

            adapter.setItems(item.items)
        }
    }
}