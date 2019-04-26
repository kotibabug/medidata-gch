package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_articles.*

class ArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        createArticleButtons()
    }

    private fun createArticleButtons() {
        articles_holder.removeAllViews()
        createButton()
        createButton()
        createButton()
    }

    private fun createButton() {
        val button1 = LayoutInflater.from(this).inflate(R.layout.area_button, null)
        val textView = button1.findViewById<TextView>(R.id.text_area)
        textView.setText("Article 1")
        articles_holder.addView(button1)
    }
}
