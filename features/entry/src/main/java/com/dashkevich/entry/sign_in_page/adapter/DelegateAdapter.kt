package com.dashkevich.entry.sign_in_page.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.dashkevich.entry.sign_in_page.adapter.model.Item
import com.dashkevich.entry.sign_in_page.adapter.model.ItemDelegate

class DelegateAdapter(
    private var itemsDelegate: List<ItemDelegate>,
) : BaseAdapter() {

    private val items: MutableList<Item> = mutableListOf()

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val item = items[position]
        val itemType = itemsDelegate.find { it.isRelativeItem(item) }
            ?.getLayoutId()
            ?: throw IllegalArgumentException("Item type not found")

        if(parent?.context!=null) {
            return itemsDelegate.find { it.getLayoutId() == itemType }
                ?.getViewHolder(parent.context, inflater, parent, item)
                ?: throw IllegalArgumentException("Layout type not found: $itemType")
        }
        throw IllegalArgumentException("Context not found")
    }

    fun setItems(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}