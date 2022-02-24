package com.basel.core.common.utils

import com.google.gson.Gson
import javax.inject.Inject

class JsonUtils @Inject constructor(private val gson: Gson) {

    /**
     * Parses json string
     * @param json string
     */
    fun <T> parseJson(json: String?, objClass: Class<T>): T? = try {
        gson.fromJson(json, objClass)
    } catch (ex: Exception) {
        null
    }

    /**
     * Parses object to json string
     * @param obj
     */
    fun <T> parseToJson(obj : T): String? = try {
        gson.toJson(obj)
    } catch (ex: Exception) {
        null
    }
}