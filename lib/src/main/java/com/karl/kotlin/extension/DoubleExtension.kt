package com.karl.kotlin.extension

import java.math.BigDecimal
import java.text.DecimalFormat

fun Double.roundHalfUp(scale: Int = 2): Double {
    val big = BigDecimal(this)
    return big.setScale(scale, BigDecimal.ROUND_HALF_UP).toDouble()
}

fun Double.roundHalfUpStr(scale: Int = 2): String {
    var pattern = "#."
    for (i in 1..scale) {
        pattern += "0"
    }
    val df = DecimalFormat(pattern)
    return df.format(this)
}