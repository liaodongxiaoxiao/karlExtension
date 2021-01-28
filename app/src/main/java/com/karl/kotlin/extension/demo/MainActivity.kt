package com.karl.kotlin.extension.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.core.widget.addTextChangedListener
import com.karl.kotlin.extension.setTextEndWithStar
import com.karl.kotlin.extension.xVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_title.setTextEndWithStar("请输入一个奇数")
        et_input.addTextChangedListener { it ->
            iv_error.xVisibility { !isOddNumber(it) }
            iv_correct.xVisibility { isOddNumber(it) }
        }
    }

    private fun isOddNumber(s: Editable?):Boolean{
        if (s!=null&& !TextUtils.isEmpty(s.toString())){
           return s.toString().toInt() % 2 != 0
        }

        return false
    }
}