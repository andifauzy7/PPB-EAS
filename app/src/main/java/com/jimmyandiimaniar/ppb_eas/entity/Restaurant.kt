package com.jimmyandiimaniar.ppb_eas.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant (
    var name: String,
    var avatar: String,
    var address: String,
    var averageCost: Int,
    var concurrency: String,
    var rating: String,
    var onlineDelivery : Int
) : Parcelable