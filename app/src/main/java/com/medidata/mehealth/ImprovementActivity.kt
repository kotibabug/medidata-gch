package com.medidata.mehealth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_improvement.*

class ImprovementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_improvement)
        layout_area_lose_weight3.setOnClickListener {
            startActivity(Intent(this@ImprovementActivity,OptionsActivity::class.java))
        }
    }
}
