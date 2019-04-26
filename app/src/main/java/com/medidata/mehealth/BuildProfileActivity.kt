package com.medidata.mehealth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.medidata.mehealth.api.Api
import com.medidata.mehealth.api.ApiService
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    public fun setProfileData(
        name: String,
        age: String,
        weight: String,
        height: String,
        gender: String,
        ethnicity: String,
        smoker: String
    ) {
        User?.name = name
        User?.age = age
        User?.weigth = weight
        User?.height = height
        User?.gender = gender
        User?.ethincity = ethnicity
        User?.smoker = smoker
    }

    public fun sendUserProfile() {

        Api.service?.createProfile(User)?.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("response failed ", t.message)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                startActivity(Intent(this@BuildProfileActivity, ImprovementActivity::class.java))
            }

        })
    }


}
