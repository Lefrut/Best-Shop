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
import com.dashkevich.home.R
import com.dashkevich.home.page1.adapter.model.LatestUI
import com.dashkevich.utility.adapter.BaseViewHolder
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate
import com.dashkevich.utility.convertDpToPixels
import com.squareup.picasso.Picasso

class LatestDelegate : ItemDelegate {

    override fun isRelativeItem(item: Item): Boolean = item is LatestUI

    override fun getLayoutId(): Int = R.layout.latest_item

    override fun createViewHolder(
        layoutInflater:
        LayoutInflater, parent: ViewGroup
    )
            : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.latest_item, parent, false)
        return ViewHolder(view, parent.context)
    }

    class ViewHolder(view: View,val  context: Context) : BaseViewHolder<LatestUI>(view) {
        private val category: TextView = view.findViewById(R.id.latest_category)
        private val price: TextView = view.findViewById(R.id.latest_price)
        private val title: TextView = view.findViewById(R.id.latest_title)
        private val image: ImageView = view.findViewById(R.id.latest_image)

        @SuppressLint("SetTextI18n")
        override fun onBind(item: LatestUI) {
            val widthPx = context.convertDpToPixels(114f).toInt()
            val heightPx = context.convertDpToPixels(149f).toInt()
            Picasso.get().load(item.image).resize(widthPx,heightPx).centerCrop().into(image);
            category.text = item.category
            title.text = item.title
            price.text = "$ " + item.price.toString()
        }
    }


}