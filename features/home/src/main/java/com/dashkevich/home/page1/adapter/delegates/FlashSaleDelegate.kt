package com.dashkevich.home.page1.adapter.delegates

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.model.FlashSaleUI
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate

class FlashSaleDelegate : ItemDelegate {

    override fun isRelativeItem(item: Item): Boolean = item is FlashSaleUI

    override fun getLayoutId(): Int = R.layout.flash_sale_item

    override fun createViewHolder(
        layoutInflater:
        LayoutInflater, parent: ViewGroup
    )
            : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flash_sale_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : BaseViewHolder<FlashSaleUI>(view) {
        private val category: TextView = view.findViewById(R.id.flash_category)
        private val price: TextView = view.findViewById(R.id.flash_price)
        private val title: TextView = view.findViewById(R.id.flash_title)
        private val discount: TextView = view.findViewById(R.id.flash_discount)
        private val image: ImageView = view.findViewById(R.id.flash_image)


        @SuppressLint("SetTextI18n")
        override fun onBind(item: FlashSaleUI) {
            category.text = item.category
            title.text = item.title
            price.text = "$ " + item.price.toString()
            discount.text = "${item.discount}% off"
        }
    }


}