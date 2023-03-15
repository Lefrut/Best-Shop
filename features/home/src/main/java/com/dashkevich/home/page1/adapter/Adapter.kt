package com.dashkevich.home.page1.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dashkevich.home.page1.adapter.delegates.TitleDelegate
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate


@Suppress("UNCHECKED_CAST")
class Adapter(
    private val itemsDelegate: List<ItemDelegate>,
) : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    private val items = mutableListOf<Item>()

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return itemsDelegate.find { it.isRelativeItem(item) }
            ?.getLayoutId()
            ?: throw IllegalArgumentException("View type not found: $item")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        val inflater = LayoutInflater.from(parent.context)
        return itemsDelegate.find { it.getLayoutId() == viewType }
            ?.createViewHolder(inflater, parent)
            ?.let { it as BaseViewHolder<Item> }
            ?: throw IllegalArgumentException("View type not found: $viewType")
    }



    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.onBind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}