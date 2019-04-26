package com.medidata.mehealth

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.annotation.StyleRes
import android.view.Window
import android.widget.TextView

/**
 * Custom Dialog/Popup using the Dialog class. Cannot be dismissed by outside touch.
 * Both button clicks will dismiss the popup.
 * @param activity - the activity this popup should be layed on. If null does nothing.
 * title - the title of the popup. If null title will be hidden.
 * message - message on the popup. If null message will be hidden.
 * startBtnText - the left button text. If null left button will be hidden.
 * endBtnText - the right button text. If null right button will be hidden.
 * textAlignment - the text alignment property for message TextView.
 * showProgressIndicator - whether to show a loading icon between title and message.
 */
class MDPopupDialog(private val activity: Activity?): Dialog(activity) {
    var startBtnHandler: (() -> Unit)? = null
    var endBtnHandler: (() -> Unit)? = null
    @StyleRes var animationStyleRes: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(GradientDrawable())
        animationStyleRes?.let {
            window?.attributes?.windowAnimations = it
        }
        setContentView(R.layout.popup_gender)
    }

    /**
     * Binds the text to popup and sets listeners on buttons.
     */
    private fun bindView() {
        setListeners()
    }

    private fun setListeners() {
        findViewById<TextView>(R.id.text_mdpopup_male)?.setOnClickListener {
            startBtnHandler?.invoke()
            dismiss()
        }
        findViewById<TextView>(R.id.text_mdpopup_female)?.setOnClickListener {
            endBtnHandler?.invoke()
            dismiss()
        }
    }

    /**
     * Dismiss the popup if visible.
     */
    override fun dismiss() {
        if (isShowing) {
            super.dismiss()
        }
    }

    override fun show() {
        bindView()
        if (isShowing) {
            dismiss()
        }
        super.show()
    }
}

