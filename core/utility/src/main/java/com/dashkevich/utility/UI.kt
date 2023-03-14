package com.dashkevich.utility

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup


fun Context.convertDpToPixels(value: Float): Float {
    val res: Resources = resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        res.displayMetrics
    )
}


fun View.setMargins(start: Int = 0, top: Int = 0, end: Int = 0, bottom: Int = 0){
    val param = layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins(start, top, end, bottom)
}