package com.example.demoapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.demoapp.routing.AppFragmentNavigator
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 * BaseFragment
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
abstract class BaseFragment : Fragment(){

  // =============================================================================================
  // DI
  // =============================================================================================
  protected val appFragmentNavigator: AppFragmentNavigator by inject { parametersOf(activity) }

  // =============================================================================================
  //  LifeCycle
  // =============================================================================================

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewReady()
  }
  

  abstract fun viewReady()
  
  //abstract fun getLayout(): Int

  // =============================================================================================
  //  Error Message Fragment
  // =============================================================================================

  open fun showError(@StringRes errorMessage: Int, rootView: View) {
    (activity as BaseActivity).showError(errorMessage, rootView)
  }
  
  open fun showError(errorMessage: String?, rootView: View) {
    (activity as BaseActivity).showError(errorMessage, rootView)
  }
  // =============================================================================================
  // Loader UI Frgment
  // =============================================================================================

  open fun showLoading(progressBar: ProgressBar) {
    (activity as BaseActivity).showLoading(progressBar)
  }
  
  open fun hideLoading(progressBar: ProgressBar) {
    (activity as BaseActivity).hideLoading(progressBar)
  }

  // =============================================================================================
  // Navigation
  // ===========================================================================================
  protected fun onBackPressed() = (activity as BaseActivity).onBackPressed()

}