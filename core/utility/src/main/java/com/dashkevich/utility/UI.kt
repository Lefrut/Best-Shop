package com.dashkevich.utility

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue


fun Context.convertDpToPixels(value: Float): Float {
    val res: Resources = resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        res.displayMetrics
    )
}