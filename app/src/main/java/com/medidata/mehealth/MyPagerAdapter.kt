package com.medidata.mehealth

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MyPagerAdapter(val context: Context, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = BuildProfileFragment()
            1 -> fragment = HistoryFragment()
            2 -> fragment = ConditionsFragment()
        }

        return fragment
    }

    override fun getCount(): Int {
        return TOTAL_PAGES
    }

    companion object {
        const val TOTAL_PAGES = 3
    }
}