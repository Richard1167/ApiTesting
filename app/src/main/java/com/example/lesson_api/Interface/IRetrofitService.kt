package com.example.lesson_api.Interface

import com.example.lesson_api.MainActivity
import com.example.lesson_api.Model.BaseDataClass
import com.example.lesson_api.Model.CharactersDataClass
import com.example.lesson_api.Model.CharactersDataClassName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRetrofitService {

        @GET("api")
        fun getAPI(
        ): Call<BaseDataClass>

        @GET("api/character")
        fun getChapters(
        ): Call<CharactersDataClass>

        @GET("api/character/{id}")
        fun getChaptersName(
                @Path("id") id: Int
        ): Call<CharactersDataClassName>


    }
