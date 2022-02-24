package com.basel.core.domain

/**
 * Interface for implementing useCase
 * @param T method parameter
 * @param V result of the performed action
 */
interface CoreSuspendUseCase<in I, out V : Any> {

    suspend fun execute(param: I): V
}