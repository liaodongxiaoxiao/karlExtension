package com.karl.kotlin.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.toast(@StringRes res: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, res, duration).show()

fun Context.getSPByKey(key: String, name: String = "sp_karl"): String? {
    val sp = this.getSharedPreferences(name, Context.MODE_PRIVATE)
    return sp.getString(key, "")
}

fun Context.putSP(key: String, value: String, name: String = "sp_karl") {
    this.getSharedPreferences(name, Context.MODE_PRIVATE).edit().apply {
        this.putString(key, value)
    }.apply()
}