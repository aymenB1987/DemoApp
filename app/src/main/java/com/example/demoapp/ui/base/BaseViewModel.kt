package com.example.demoapp.ui.base
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.common.couroutine.CoroutineContextProvider
import com.example.data.common.utils.Connectivity
import com.example.demoapp.common.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * BaseViewModel
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
abstract class BaseViewModel<T : Any, E> : ViewModel(), KoinComponent {

  // =============================================================================================
  // DI
  // =============================================================================================
  protected val coroutineContext: CoroutineContextProvider by inject()
  private val connectivity: Connectivity by inject()

  // =============================================================================================
  // ViewModel Run
  // =============================================================================================
  protected val _viewState = MutableLiveData<ViewState<T>>()
  val viewState: LiveData<ViewState<T>>
    get() = _viewState

  protected val _viewEffects = MutableLiveData<E>()
  val viewEffects: LiveData<E>
    get() = _viewEffects

  protected fun executeUseCase(action: suspend () -> Unit, noInternetAction: () -> Unit) {
    _viewState.value = Loading()
    if (connectivity.hasNetworkAccess()) {
      launch { action() }
    } else {
      noInternetAction()
    }
  }

  protected fun executeUseCase(action: suspend () -> Unit) {
    _viewState.value = Loading()
    launch { action() }
  }
}