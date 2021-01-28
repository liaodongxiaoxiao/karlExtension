package com.ftms.superapp.mall.extension

import android.os.Bundle
import android.os.Parcelable

/**
 * Bundle扩展函数
 */

/**
 * 向Bundle中放置 Parcelable类型的MutableList数据集
 * @param key key
 * @param list 参数
 */
fun <T : Parcelable> Bundle.putParcelableMutableList(key: String, list: MutableList<T>) {
    this.putParcelableArrayList(key, ArrayList(list))
}

fun <T : Parcelable> Bundle.getParcelableMutableList(key: String): MutableList<T>? {
    val list: ArrayList<T>? = this.getParcelableArrayList(key)
    if (list != null && list.isNotEmpty()) {
        val result: MutableList<T> = mutableListOf()
        for (t: T in list) {
            result.add(t)
        }
        return result
    }
    return null
}