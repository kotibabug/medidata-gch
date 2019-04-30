package com.medidata.mehealth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_conditions.*


class ConditionsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_conditions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_next.setOnClickListener {
            var check1 = checkbox_cancer.isChecked
            var check2 = checkbox_blood.isChecked
            var check3 = checkbox_depression.isChecked
            var check4 = checkbox_diabetes.isChecked
            val ab = if (check1) "cancer"
            else if (check2) "blood"
            else if (check3) "depression"
            else "diabetes"
            User.condition = ab
            (activity as BuildProfileActivity).sendUserProfile()
        }
    }
}
