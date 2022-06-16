package com.karl.kotlin.extension

import android.content.Intent
import android.os.Parcelable

inline fun Intent?.getStrParam(key: String, defaultValue: String = ""): String {
    return if (this != null && this.hasExtra(key)) {
        this.getStringExtra(key) ?: defaultValue
    } else {
        defaultValue
    }
}

inline fun Intent?.getIntParam(key: String, defaultValue: Int = 0): Int {
    return if (this != null && this.hasExtra(key)) {
        this.getIntExtra(key, defaultValue)
    } else {
        defaultValue
    }
}

inline fun Intent?.getDoubleParam(key: String, defaultValue: Double = 0.0): Double {
    return if (this != null && this.hasExtra(key)) {
        this.getDoubleExtra(key, defaultValue)
    } else {
        defaultValue
    }
}

inline fun Intent?.getBooleanParam(key: String, defaultValue: Boolean = false): Boolean {
    return if (this != null && this.hasExtra(key)) {
        this.getBooleanExtra(key, defaultValue)
    } else {
        defaultValue
    }
}

inline fun <reified T : Parcelable> Intent?.getParcelableParam(key: String): T? {
    return if (this != null && this.hasExtra(key)) {
        this.getParcelableExtra<T>(key)
    } else {
        null
    }
}