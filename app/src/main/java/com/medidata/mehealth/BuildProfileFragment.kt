package com.medidata.mehealth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_build_profile.*
import android.widget.Toast


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
        btn_next.setOnClickListener {
            (activity as BuildProfileActivity).setProfileData(
                edit_name.text.toString()
                , edit_age.text.toString(),
                edit_weigth.text.toString(), edit_height.text.toString(),
                edit_gender.text.toString(), edit_ethnicity.text.toString(),
                edit_smoking.text.toString()
            )
            (activity as BuildProfileActivity).sendUserProfile()
           // (activity as BuildProfileActivity).goNext()
        }
    }
}
