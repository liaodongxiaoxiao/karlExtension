package com.karl.kotlin.extension

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes


fun EditText.isEmpty(): Boolean {
    return TextUtils.isEmpty(this.text)
}

fun TextView.setTextEndWithStar(text: CharSequence, @ColorInt colorInt: Int = Color.RED) {
    val span = SpannableString("$text*")
    span.setSpan(
        ForegroundColorSpan(colorInt),
        text.length,
        text.length + 1,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    this.text = span
}

fun TextView.setTextEndWithStar(@StringRes textInt: Int, @ColorInt colorInt: Int = Color.RED) {
    this.setTextEndWithStar(context.resources.getText(textInt), colorInt)
}

fun RadioGroup.getCheckedText(): String? {
    val id = this.checkedRadioButtonId
    val radio = this.findViewById<RadioButton>(id)
    if (radio != null) {
        return radio.text.toString()
    } else {
        return null
    }
}

fun ViewGroup.inflate(@LayoutRes resource: Int): View {
    return LayoutInflater.from(this.context).inflate(
        resource,
        this,
        false
    )
}

fun ViewGroup.inflateNullRoot(@LayoutRes resource: Int): View {
    return LayoutInflater.from(this.context).inflate(
        resource,
        null,
        false
    )
}

fun View.xVisibility(block: () -> Boolean) {
    if (block()){
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}
