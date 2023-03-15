package com.dashkevich.home.page1.adapter.delegates

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.model.FlashSaleUI
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate
import com.dashkevich.utility.convertDpToPixels
import com.squareup.picasso.Picasso

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
        return ViewHolder(view, parent.context)
    }

    class ViewHolder(view: View,val context: Context) : BaseViewHolder<FlashSaleUI>(view) {
        private val category: TextView = view.findViewById(R.id.flash_category)
        private val price: TextView = view.findViewById(R.id.flash_price)
        private val title: TextView = view.findViewById(R.id.flash_title)
        private val discount: TextView = view.findViewById(R.id.flash_discount)
        private val image: ImageView = view.findViewById(R.id.flash_image)


        @SuppressLint("SetTextI18n")
        override fun onBind(item: FlashSaleUI) {
            val widthPx = context.convertDpToPixels(1000f).toInt()
            val heightPx = context.convertDpToPixels(1000f).toInt()
            Picasso.get().load(item.image).resize(widthPx,heightPx).centerCrop().into(image);
            category.text = item.category
            title.text = item.title
            price.text = "$ " + item.price.toString()
            discount.text = "${item.discount}% off"
        }
    }


}