package com.karl.kotlin.extension.demo

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.karl.kotlin.extension.getParcelableParam
import com.karl.kotlin.extension.getStrParam
import com.karl.kotlin.extension.jsonLog
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class SecondActivity : AppCompatActivity() {
    private val name by lazy { intent.getStrParam(Constant.KEY_NAME) }
    private val pa: Data? by lazy { intent.getParcelableParam(Constant.KEY_PA) }
    private val age by IntentParametersDelegate<String>()

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
                age:$age
            """.trimIndent()
        )

        pa?.jsonLog()
    }
}

class IntentStringParametersDelegate : ReadWriteProperty<Activity, String?> {
    override fun getValue(thisRef: Activity, property: KProperty<*>): String? {
        if (thisRef.intent.hasExtra(property.name)) {
            return thisRef.intent.getStringExtra(property.name)
        } else {
            return null
        }
    }

    override fun setValue(thisRef: Activity, property: KProperty<*>, value: String?) {

    }

}

//fun  <T>  intentParameter() :T?

class IntentParametersDelegate<T : Any>(private val kClass: KClass<T>) :
    ReadWriteProperty<Activity, @UnsafeVariance T?> {

    override fun getValue(thisRef: Activity, property: KProperty<*>): T? {
        return if (thisRef.intent.hasExtra(property.name)) {
            when (kClass) {
                String::class -> {
                    thisRef.intent.getStringExtra(property.name) as T
                }
                Int::class -> {
                    thisRef.intent.getIntExtra(property.name, 0) as T
                }
                Boolean::class->{
                    thisRef.intent.getBooleanExtra(property.name, false) as T
                }
                else -> null
            }

        } else {
            null
        }
    }

    override fun setValue(thisRef: Activity, property: KProperty<*>, value: T?) {

    }

    companion object {
        inline operator fun <reified T : Any> invoke() = IntentParametersDelegate(T::class)
    }

}
