package com.basel.core.common.data.network

import com.basel.core.common.data.constants.CoreConstant.APPLICATION_JSON
import com.basel.core.common.data.constants.CoreConstant.AUTHORIZATION_HEADER
import com.basel.core.common.data.constants.CoreConstant.CONTENT_TYPE
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(
                AUTHORIZATION_HEADER,
                "23863708:465c0554fd00da006338c72e282e939fe6576a25fd00c776c0fbe898c47c9876"
            )
            .build()
        return chain.proceed(newRequest)
    }
}