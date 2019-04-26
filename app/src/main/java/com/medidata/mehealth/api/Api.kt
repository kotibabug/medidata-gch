package com.medidata.mehealth.api

import retrofit2.Retrofit



object Api {
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        val service = retrofit.create<GitHubService>(GitHubService::class.java!!)
    }
}