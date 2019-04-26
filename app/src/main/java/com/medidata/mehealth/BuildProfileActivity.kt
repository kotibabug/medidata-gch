package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class BuildProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUpView()
    }

    private fun setUpView() {
        pager.adapter = MyPagerAdapter(this, supportFragmentManager)
        pager.setCurrentItem(0, true)
        pager.offscreenPageLimit = 3
        indicator.setupWithViewPager(pager, false)
    }

    public fun goNext() {
        pager.setCurrentItem(pager.currentItem + 1, true)
    }

}
