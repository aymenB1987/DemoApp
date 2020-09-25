package com.example.demoapp.ui.base
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.demoapp.common.*
import com.example.demoapp.routing.AppNavigator

import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


/**
 * BaseActivity
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
abstract class BaseActivity : AppCompatActivity() {

  // =============================================================================================
  // DI
  // =============================================================================================
  protected val appNavigator: AppNavigator by inject { parametersOf(this) }

  // =============================================================================================
  //  Error Message Acticity
  // =============================================================================================
  
  fun showError(@StringRes errorMessage: Int, rootView: View) = snackbar(errorMessage, rootView)
  
  fun showError(errorMessage: String?, rootView: View) = snackbar(errorMessage ?: EMPTY_STRING, rootView)

  // =============================================================================================
  // Loader UI Activity
  // =============================================================================================

  fun showLoading(progressBar: ProgressBar) = progressBar.visible()
  
  fun hideLoading(progressBar: ProgressBar) = progressBar.gone()


  // =============================================================================================
  // Adding Fragment
  // =============================================================================================

  fun addFragment(fragment: Fragment, containerId: Int, addToBackStack: Boolean = false) {
    showFragment(fragment, containerId, addToBackStack)
  }
  
  override fun onBackPressed() {
    if (supportFragmentManager.backStackEntryCount <= 1) finish() else goBack()
  }
}