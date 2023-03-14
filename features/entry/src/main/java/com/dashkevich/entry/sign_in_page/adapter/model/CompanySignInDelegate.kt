package com.dashkevich.entry.sign_in_page.adapter.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.dashkevich.entry.R
import com.dashkevich.utility.adapter.Item
import com.dashkevich.utility.adapter.ItemDelegate
import com.dashkevich.utility.convertDpToPixels
import com.dashkevich.utility.setMargins

class CompanySignInDelegate(val onClick: () -> Unit) : ItemDelegate {

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
        val layout = view.findViewById<ConstraintLayout>(R.id.company_item_layout)
        if(item is CompanySignIn){
            icon.setImageResource(item.icon)
            text.text = context.getString(item.text)
            val px = context.convertDpToPixels(item.iconMarginEnd.toFloat())
            icon.setMargins(0, 0, px.toInt(), 0)
            layout.setOnClickListener {
                onClick.invoke()
            }
        }
        return view
    }

}
