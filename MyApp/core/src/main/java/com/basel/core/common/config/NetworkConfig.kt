package com.basel.core.common.config


import com.basel.core.data.constants.CoreConstant
import com.basel.core.data.network.AuthorizationInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
/**
 * Create retrofit web service
 */
inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    baseUrl: String
): T = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(T::class.java)


/**
 * OkHttpClient only use for retrofit
 */
fun createRetrofitOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpBuilder = OkHttpClient.Builder()
        .connectTimeout(CoreConstant.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CoreConstant.READ_TIMEOUT, TimeUnit.MILLISECONDS)
    okHttpBuilder.addInterceptor(httpLoggingInterceptor)
    okHttpBuilder.addInterceptor(AuthorizationInterceptor())
    return okHttpBuilder.build()
}
