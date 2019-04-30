package com.medidata.mehealth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.medidata.mehealth.api.Api
import kotlinx.android.synthetic.main.activity_result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        Api.service?.getResult(User.condition?:"cancer",User.gender?:"male", User.age?:"29","US" )?.enqueue(object :
            Callback<List<Article>> {
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                response.body()?.let {
                    createArticleButtons(it)
                }


            }
        })

    }

    private fun createArticleButtons(list: List<Article>) {
        layout_results.removeAllViews()
        list.forEach {
            createButton(it)
        }
    }

    private fun createButton(art: Article) {
        val button1 = LayoutInflater.from(this).inflate(R.layout.layout_result, null)
        val title = button1.findViewById<TextView>(R.id.text_title)
        val summary = button1.findViewById<TextView>(R.id.summary)
        title.setText(art.title)
        summary.setText(art.url)
        layout_results.addView(button1)
    }
}
