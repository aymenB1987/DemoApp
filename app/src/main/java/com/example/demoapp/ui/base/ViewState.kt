package com.example.demoapp.ui.base
/**
 * ViewState
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
sealed class ViewState<out T : Any>

// =============================================================================================
//  List State for my custom LifeCycle
// =============================================================================================

class Success<out T : Any>(val data: T) : ViewState<T>()
class Error<out T : Any>(val error: Throwable) : ViewState<T>()
class Loading<out T : Any> : ViewState<T>()
class NoInternetState<T : Any> : ViewState<T>()


