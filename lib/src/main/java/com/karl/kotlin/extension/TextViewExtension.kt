package com.karl.kotlin.extension

import android.widget.TextView
import java.lang.Exception

fun TextView.intValue(default: Int = 0): Int {
    if (!this.text.isNullOrEmpty()) {
        try {
            return this.text.toString().toInt()
        } catch (e: Exception) {

        }
    }

    return default
}

fun TextView.doubleValue(default: Double = 0.0): Double {
    if (!this.text.isNullOrEmpty()) {
        try {
            return this.text.toString().toDouble()
        } catch (e: Exception) {

        }
    }

    return default
}