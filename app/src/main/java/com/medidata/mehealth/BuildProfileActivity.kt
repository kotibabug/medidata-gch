package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_build_profile.*

class BuildProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_profile)

        edit_gender.setOnClickListener {
            MDPopupDialog(this).apply {
                startBtnHandler = {
                    Toast.makeText(this@BuildProfileActivity, "male", Toast.LENGTH_SHORT).show()
                }
                endBtnHandler = {
                    Toast.makeText(this@BuildProfileActivity, "female", Toast.LENGTH_SHORT).show()
                }
                create()
                show()
            }
        }
    }
}
