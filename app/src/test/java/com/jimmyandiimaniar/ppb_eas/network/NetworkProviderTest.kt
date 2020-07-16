package com.jimmyandiimaniar.ppb_eas.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit

class NetworkProviderTest {

    @Test
    fun compareTwoObjectRetrofit() {
        assertEquals(Retrofit.Builder().equals(Retrofit.Builder()),
            NetworkProvider.providesHttpAdapter().newBuilder().equals(Retrofit.Builder()))
    }
    @Test
    fun compareTwoObjectOkHttp() {
        assertEquals(
            OkHttpClient.Builder().equals(OkHttpClient.Builder()),
            NetworkProvider.providesHttpClient().equals(OkHttpClient.Builder()))
    }
    @Test
    fun compareTwoObjectLoggingInterceptor() {
        assertEquals(
            HttpLoggingInterceptor.Level.BODY,
            NetworkProvider.providesHttpLoggingInterceptor().level)
    }
}