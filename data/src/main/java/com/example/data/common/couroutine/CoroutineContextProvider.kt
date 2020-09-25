package com.example.data.common.couroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * CoroutineProvider
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */


open class CoroutineContextProvider {
  open val main: CoroutineContext by lazy { Dispatchers.Main }
  open val io: CoroutineContext by lazy { Dispatchers.IO }
  open val default: CoroutineContext by lazy { Dispatchers.Default }
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
  override val main: CoroutineContext = Dispatchers.Unconfined
  override val io: CoroutineContext = Dispatchers.Unconfined
  override val default: CoroutineContext = Dispatchers.Unconfined
}