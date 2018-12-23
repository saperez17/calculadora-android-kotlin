package com.cluster.android.kotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cluster.android.kotlinex.R.id.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var value:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAdd.setOnClickListener(this::operar)
        btnSub.setOnClickListener(this::operar)
        btnMul.setOnClickListener(this::operar)
        btnDiv.setOnClickListener(this::operar)

        value = savedInstanceState?.getString("value") ?: "00"
        txtResul.text = value
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("value", value)
        super.onSaveInstanceState(outState)



    }


    fun operar (view:View){
        val n1 = "0${txtNum1.text}".toInt()
        val n2 = "0${txtNum2.text}".toInt()

        value = when(view.id){
            R.id.btnAdd -> n1 + n2
            R.id.btnSub -> n1 - n2
            R.id.btnMul -> n1 * n2
            else -> n1 / n2
        }.toString()

        txtResul.text=(value)

    }




}
