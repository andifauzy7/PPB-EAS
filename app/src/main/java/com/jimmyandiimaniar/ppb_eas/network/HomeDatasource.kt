package com.jimmyandiimaniar.ppb_eas.network

import com.jimmyandiimaniar.ppb_eas.model.restaurantFromSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeDatasource {
    @Headers("user-key: 87191e9d7e4a6faef52a64788f9ccd6c")
    @GET("search")
    fun discoverRestaurantFromSearch(
        @Query("entity_id")
        q: Int = 11052,
        @Query("entity_type")
        entity_type: String = "city"
    ): Call<restaurantFromSearch>
}