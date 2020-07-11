package com.jimmyandiimaniar.ppb_eas.network

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("location_suggestions")
    val result: List<Cities>
)

data class Cities(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)