package com.karl.kotlin.extension.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.karl.kotlin.extension.getParcelableParam
import com.karl.kotlin.extension.getStrParam
import com.karl.kotlin.extension.jsonLog

class SecondActivity : AppCompatActivity() {
    private val name by lazy { intent.getStrParam(Constant.KEY_NAME) }
    private val pa: Data? by lazy { intent.getParcelableParam(Constant.KEY_PA) }

    //private lateinit var name:String
    ///private lateinit var age:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //name = intent.getStrParam(Constant.KEY_NAME)
        //age = intent.getIntParam("kkk")
        findViewById<TextView>(R.id.tv_info).setText(
            """
                name:$name
            """.trimIndent()
        )

        pa?.jsonLog()
    }
}