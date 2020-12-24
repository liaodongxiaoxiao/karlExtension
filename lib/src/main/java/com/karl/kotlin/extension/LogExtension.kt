package com.karl.kotlin.extension

import android.util.Log
import com.google.gson.Gson


const val TAG = "KarlTag"
inline fun <reified T> T?.log(log: Boolean = true) {
    if (log) {
        val name = T::class.java.simpleName
        //Log.e(TAG, "$name:${this.toString()}")
        toLog(TAG, "$name:${this.toString()}")
    }
}

inline fun <reified T> T?.log(key: String, log: Boolean = true) {
    if (log) {
        //val name = T::class.java.simpleName
        //Log.e(TAG, "$key--->:${this.toString()}")
        toLog(TAG, "$key--->:${this.toString()}")
    }
}


inline fun <reified T> T?.jsonLog(log: Boolean = true) {
    if (log) {
        val gson = Gson()
        val name = T::class.java.simpleName
        //Log.e(TAG, "$name:${gson.toJson(this)}")
        toLog(TAG, "$name:${gson.toJson(this)}")
    }
}

fun Throwable.log(tag: String = TAG, log: Boolean = true) {
    if (log) {
        Log.e(TAG, this.message, this)
    }
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
