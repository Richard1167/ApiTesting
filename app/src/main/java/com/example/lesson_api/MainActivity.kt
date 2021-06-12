package com.example.lesson_api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lesson_api.databinding.ActivityMainBinding
import com.example.lesson_api.retrofit.service.BaseService

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BaseService().getBaseApi { data, e ->

            if (data != null && e == null) {
                Log.e("testingAPI", data.characters.toString())
                Log.e("testingAPI", data.episodes.toString())
                Log.e("testingAPI", data.locations.toString())
                data.characters
                data.episodes
                data.locations
            } else {
                Log.e("testingAPI", "Exception", e)

            }
        }

        BaseService().getCharacters { data, e ->
            Log.e("testingAPI", data?.info?.count.toString())

        }

        binding.button.setOnClickListener {
            var numbuser = binding.editNumber.text.toString().toInt()
            BaseService().getCharactersName(numbuser) { data, e ->
                binding.textV.text = data?.name.toString()
            }

            BaseService().getCharactersName(numbuser) { data, e ->
                if (data != null && e == null) {

                    Log.e("testingAPI", data?.name.toString())

                    Glide.with(this)
                        .load(data.image)
                            //Тут можно писать код пользуясь функциями глайда
                        .into(binding.photo)
                } else {
                    Log.e("testingAPI", "newError2", e)
                }
            }

        }

    }
}
