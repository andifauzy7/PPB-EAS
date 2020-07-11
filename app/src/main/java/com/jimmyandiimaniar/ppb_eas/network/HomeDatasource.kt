package com.jimmyandiimaniar.ppb_eas.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeDatasource {
    @Headers("user-key: 87191e9d7e4a6faef52a64788f9ccd6c")
    @GET("cities")
    fun discoverCities(
        @Query("q")
        q: String = "Bandung"
    ): Call<HomeResponse>
}