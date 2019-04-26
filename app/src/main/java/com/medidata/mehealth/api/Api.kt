package com.medidata.mehealth.api

import com.medidata.mehealth.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


object Api {
    var service: ApiService? = null
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://epam-hack19-nyc-3968.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<ApiService>(ApiService::class.java!!)
    }
}

interface ApiService {
    @POST("users.json")
    fun createProfile(@Body user: User): Call<User>
}