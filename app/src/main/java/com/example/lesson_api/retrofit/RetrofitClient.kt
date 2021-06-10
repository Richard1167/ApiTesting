package com.example.lesson_api.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

     private var retrofit: Retrofit? = null
    var baseURL = "https://rickandmortyapi.com/"

    fun getURL(baseURL: String) :Retrofit{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }

}










//if (retrofit == null) {
//    RetrofitClient.retrofit = Retrofit.Builder()
//            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//}
//return retrofit!!