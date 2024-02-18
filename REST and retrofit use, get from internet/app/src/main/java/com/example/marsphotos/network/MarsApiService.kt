package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface MarsApiService { //provides the possible services or functions
    @GET("photos")
    suspend fun getphotos() :String
}

object MarsApi{ //provides a convenient way of access
    val retrofitService : MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder() // helps with creating a builder which is used in creating an object
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
