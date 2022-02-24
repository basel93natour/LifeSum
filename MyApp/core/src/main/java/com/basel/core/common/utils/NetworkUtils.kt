package com.basel.core.common.utils

import com.basel.core.data.constants.CoreConstant.HTTP_ERROR
import com.basel.core.data.constants.CoreConstant.INTERNET_NOT_AVAILABLE_ERROR
import com.basel.core.data.constants.CoreConstant.UNEXPECTED_APPLICATION_ERROR
import com.basel.core.data.network.DefaultExceptionBodyDTO
import retrofit2.HttpException
import java.net.UnknownHostException

/**
 * Function handles http errors
 * @param call suspend function
 */
suspend fun <T : Any> safeApiCall(
    call: suspend () -> T
): T {

    return try {
        call.invoke()
    } catch (e: Throwable) {
        throw handleException(e)
    }
}

/**
 * Error handler for http requests
 * [ex] - exception
 */
fun handleException(
    ex: Throwable
): DefaultExceptionBodyDTO {
    return when (ex) {
        is HttpException -> DefaultExceptionBodyDTO(message = "$HTTP_ERROR (${ex.code()})")
        is UnknownHostException -> throw DefaultExceptionBodyDTO(message = INTERNET_NOT_AVAILABLE_ERROR)
        else -> throw DefaultExceptionBodyDTO(message = UNEXPECTED_APPLICATION_ERROR)
    }
}