package com.karl.kotlin.extension

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideSoftKeyboard(view: View? = null) {
    val currentView: View? = view ?: this.currentFocus
    if (currentView != null) {
        val inputMethodManager: InputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //InputMethodManager.HIDE_NOT_ALWAYS
        inputMethodManager.hideSoftInputFromWindow(currentView.windowToken, 0)
    }

}