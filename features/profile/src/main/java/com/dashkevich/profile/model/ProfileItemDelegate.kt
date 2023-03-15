package com.dashkevich.profile.model

import android.R.attr
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.dashkevich.profile.R
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate
import com.dashkevich.utility.convertDpToPixels
import com.dashkevich.utility.setMargins


class ProfileItemDelegate(): ItemDelegate {
    override fun isRelativeItem(item: Item): Boolean = item is ProfileItem

    override fun getLayoutId(): Int = R.layout.profile_item

    @SuppressLint("SetTextI18n")
    override fun getViewHolder(
        context: Context,
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        item: Item
    ): View {
        val view = LayoutInflater.from(context).inflate(getLayoutId(), parent, false)
        with(view) {
            val icon = findViewById<ImageView>(R.id.icon)
            val text = findViewById<TextView>(R.id.text)
            val arrow = findViewById<ImageView>(R.id.arrow)
            val money = findViewById<TextView>(R.id.money)
            if(item is ProfileItem){
                icon.setImageResource(item.icon)
                text.text = context.getString(item.text)
                val px = context.convertDpToPixels(item.marginEnd.toFloat()).toInt()
                if(item.haveArrow) {
                    arrow.setMargins(0, 0, px.toInt(), 0)
                }else{
                    money.setMargins(0, 0, px.toInt(), 0)
                }
                arrow.isVisible = item.haveArrow
                money.text = "$ ${item.money.toInt()}"
                money.isVisible = item.haveMoney
                view.setOnClickListener {
                    item.onClick.invoke()
                }
            }
        }
        return view
    }
}