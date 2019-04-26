package com.medidata.mehealth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_build_profile.*

class BuildProfileFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_build_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_gender.setOnClickListener {
            MDPopupDialog(activity).apply {
                startBtnHandler = {
                    Toast.makeText(context, "male", Toast.LENGTH_SHORT).show()
                }
                endBtnHandler = {
                    Toast.makeText(context, "female", Toast.LENGTH_SHORT).show()
                }
                create()
                show()
            }
        }
    }
}
