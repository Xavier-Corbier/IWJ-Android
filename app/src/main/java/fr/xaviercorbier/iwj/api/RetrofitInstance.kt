package fr.xaviercorbier.iwj.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val gson by lazy {
        GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

    fun createCallApi() : SimpleApi {
        return api
    }
}