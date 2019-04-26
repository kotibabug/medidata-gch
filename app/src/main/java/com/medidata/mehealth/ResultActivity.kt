package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        createArticleButtons()
    }

    private fun createArticleButtons() {
        layout_results.removeAllViews()
        createButton()
        createButton()
        createButton()
    }

    private fun createButton() {
        val button1 = LayoutInflater.from(this).inflate(R.layout.layout_result, null)
        val title = button1.findViewById<TextView>(R.id.text_title)
        val summary = button1.findViewById<TextView>(R.id.summary)
        title.setText("Article 1")
        summary.setText("Article Summary")
        layout_results.addView(button1)
    }
}
