package com.karl.kotlin.extension

import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

fun String?.dateFormat(defaultFormat: String = "yyyy-MM-dd HH:mm:ss", toFormat: String): String {
    val format = SimpleDateFormat(defaultFormat, Locale.getDefault())
    try {
        val date = format.parse(this)
        val to = SimpleDateFormat(toFormat, Locale.getDefault())
        return to.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""
}

fun String?.md5(): String {
    val tmp = if (this.isNullOrBlank()) {
        Date().time.toString()
    } else {
        this
    }

    val md = MessageDigest.getInstance("MD5")
    val bigInt = BigInteger(1, md.digest(tmp.toByteArray(Charsets.UTF_8)))
    return String.format("%032x", bigInt)
}