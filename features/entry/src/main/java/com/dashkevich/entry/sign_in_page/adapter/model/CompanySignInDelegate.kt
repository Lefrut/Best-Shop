package com.dashkevich.entry.sign_in_page.adapter.model

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dashkevich.entry.R
import com.dashkevich.utility.convertDpToPixels

class CompanySignInDelegate() : ItemDelegate {

    override fun isRelativeItem(item: Item): Boolean = item is CompanySignIn

    override fun getLayoutId(): Int = R.layout.company_item

    override fun getViewHolder(
        context: Context,
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        item: Item
    ): View {
        val view = LayoutInflater.from(context).inflate(getLayoutId(), parent, false)
        val icon = view.findViewById<ImageView>(R.id.company_icon)
        val text = view.findViewById<TextView>(R.id.company_sign_in)
        if(item is CompanySignIn){
            icon.setImageResource(item.icon)
            text.text = context.getString(item.text)
            val px = context.convertDpToPixels(item.iconMarginEnd.toFloat())
            val iconParam = icon.layoutParams as ViewGroup.MarginLayoutParams
            iconParam.setMargins(0, 0, px.toInt(), 0)
        }
        return view
    }

}
