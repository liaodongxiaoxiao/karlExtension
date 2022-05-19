package com.karl.kotlin.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Context 相关扩展
 */
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

inline fun <T : Activity> Context.justStartActivity(clazz: Class<T>){
    this.startActivity(Intent(this,clazz))
}