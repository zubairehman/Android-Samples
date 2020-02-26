package com.iotecksolution.foregroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iotecksolution.forgroundservice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startService(view: View) {
        val input = et_input.text.toString()

        val intent = Intent(this, ExampleService::class.java)
        intent.putExtra("input", input)
        startService(intent)
    }

    fun stopService(view: View) {
        val intent = Intent(this, ExampleService::class.java)
        stopService(intent)
    }
}
