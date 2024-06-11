package com.example.randomimage.newtwork

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewtworkClient {
    private var service: DogApi? = null

    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun initClient() {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(DogApi::class.java)

    }

    fun getDogImage(callback: (String) -> Unit) {
        service?.getRandomImage()?.enqueue(object : Callback<DogAnswer> {
            override fun onResponse(p0: Call<DogAnswer>, response: Response<DogAnswer>) {
                Log.i("Запрос сервера","Ответ успешный: ${response.body()}")
                callback.invoke(response.body()?.message?: "")
            }

            override fun onFailure(p0: Call<DogAnswer>, response: Throwable) {
                Log.e("Запрос сервера","Ответ мы не получили")
            }
        })
    }           

}