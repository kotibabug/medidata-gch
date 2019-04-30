package com.medidata.mehealth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.medidata.mehealth.api.Api
import kotlinx.android.synthetic.main.activity_options.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable


class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        layout_area_lose_weight2.setOnClickListener {
            var intent = Intent(this@OptionsActivity, ResultActivity::class.java)
            startActivity(intent)

        }
    }
}
