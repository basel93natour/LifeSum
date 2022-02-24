package com.basel.core.common.utils

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
        throw  e
    }
}