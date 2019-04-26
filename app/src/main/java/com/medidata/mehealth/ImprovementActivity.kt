package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

class ImprovementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_improvement)
    }

    private fun createButtons() {
        val button1 = LayoutInflater.from(this).inflate(R.layout.area_button, null)
    }
}
