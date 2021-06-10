package com.example.lesson_api.retrofit.service

import android.util.Log
import com.example.lesson_api.Interface.IRetrofitService
import com.example.lesson_api.Model.BaseDataClass
import com.example.lesson_api.Model.CharactersDataClass
import com.example.lesson_api.Model.CharactersDataClassName
import com.example.lesson_api.retrofit.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BaseService {

    fun getBaseApi(onLoaded : (data: BaseDataClass?, e: Throwable?) -> Unit) {
        getRetrofit().create(IRetrofitService ::class.java)
            .getAPI()
            .enqueue(object : Callback<BaseDataClass> {
                override fun onResponse(
                    call: Call<BaseDataClass>,
                    response: Response<BaseDataClass>
                ) {
                    onLoaded.invoke(response.body(), null)
                }

                override fun onFailure(call: Call<BaseDataClass>, t: Throwable) {
                    onLoaded.invoke(null, t)
                }
            })
    }


    fun getCharacters(onLoaded : (data: CharactersDataClass?, e: Throwable?) -> Unit) {
        getRetrofit().create(IRetrofitService ::class.java)
            .getChapters()
            .enqueue(object : Callback<CharactersDataClass> {
                override fun onResponse(
                    call: Call<CharactersDataClass>,
                    response: Response<CharactersDataClass>
                ) {
                    onLoaded.invoke(response.body(), null)
                }

                override fun onFailure(call: Call<CharactersDataClass>, t: Throwable) {
                    onLoaded.invoke(null, t)
                }
            })
    }

    fun getCharactersName(id : Int, onLoaded : (data: CharactersDataClassName?, e: Throwable?) -> Unit) {
        getRetrofit().create(IRetrofitService ::class.java)
            .getChaptersName(id)
            .enqueue(object : Callback<CharactersDataClassName> {
                override fun onResponse(
                    call: Call<CharactersDataClassName>,
                    response: Response<CharactersDataClassName>
                ) {
                    onLoaded.invoke(response.body(), null)
                    Log.e("testingAPI", "success")
                }

                override fun onFailure(call: Call<CharactersDataClassName>, t: Throwable) {
                    onLoaded.invoke(null, t)
                    Log.e("testingAPI", "error2", t)
                }
            })
    }
}