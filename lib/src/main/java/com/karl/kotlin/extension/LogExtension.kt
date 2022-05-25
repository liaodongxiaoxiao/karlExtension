package com.karl.kotlin.extension

import android.util.Log
import com.google.gson.Gson


const val TAG = "KarlTag"
inline fun <reified T> T?.log(log: Boolean = true) {
    if (log) {
        val name = T::class.java.simpleName
        toLog(TAG, "$name:${this.toString()}")
    }
}

inline fun <reified T> T?.log(key: String, log: Boolean = true) {
    if (log) {
        toLog(TAG, "$key--->:${this.toString()}")
    }
}


inline fun <reified T> T?.jsonLog(log: Boolean = true) {
    if (log) {
        val gson = Gson()
        val name = T::class.java.simpleName
        toLog(TAG, "$name:${gson.toJson(this)}")
    }
}

fun Throwable.log(tag: String = TAG) {
    Log.e(TAG, "Exception Info:${this.message}", this)
}

fun toLog(tag: String, msg: String) {

    val segmentSize = 3 * 1024
    val length: Long = msg.length.toLong()
    if (length <= segmentSize) {
        Log.e(tag, msg)
    } else {
        var tmpMsg = msg
        // 循环分段打印日志
        while (tmpMsg.length > segmentSize) {
            val logContent: String = tmpMsg.substring(0, segmentSize)
            tmpMsg = tmpMsg.replace(logContent, "")
            Log.e(tag, logContent)
        }
        // 打印剩余日志
        Log.e(tag, msg)
    }
}
