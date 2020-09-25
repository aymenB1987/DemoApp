package com.example.domain.base

import com.example.domain.model.Result


/**
 * BaseUseCase
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
interface BaseUseCase<T : Any, R: Any> {
  suspend operator fun invoke(param: T): Result<R>
}