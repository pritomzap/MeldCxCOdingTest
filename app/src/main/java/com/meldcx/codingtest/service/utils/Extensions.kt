package com.meldcx.codingtest.service.utils

import android.R
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Patterns
import android.view.View
import android.webkit.URLUtil
import okhttp3.HttpUrl


fun String.isValidUrl(): String? {
    if (!Patterns.WEB_URL.matcher(this).matches()) {
        return "Wrong server address"
    }

    if (HttpUrl.parse(this) == null) {
        return "Wrong server address"
    }

    if (!URLUtil.isValidUrl(this)) {
        return "Wrong server address"
    }

    if (!this.substring(0, 7).contains("http://") and !this.substring(0, 8).contains("https://")) {
        return "Wrong server address"
    }
    return null
}

fun View.gone() {
    if (visibility != View.GONE)
        visibility = View.GONE
}

fun View.visible() {
    if (visibility != View.VISIBLE)
        visibility = View.VISIBLE
}

fun View.invisible() {
    if (visibility != View.INVISIBLE)
        visibility = View.INVISIBLE
}

fun View.loadBitmapFromView(): Bitmap? {
    this.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    val bitmap = Bitmap.createBitmap(
        this.measuredWidth,
        this.measuredHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    this.layout(0, 0, this.measuredWidth, this.measuredHeight)
    this.draw(canvas)
    return bitmap
}