package com.example.demoapp.routing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.ui.base.BaseActivity
import java.io.Serializable


/**
 *AppNavigator
 * Aymen Bouali
 * Coyote
 * @date 23/09/2020
 */
class AppNavigator(private val activity: AppCompatActivity) : Navigator {
  
  companion object {
    const val SCREEN_TYPE = "screen_type"
  }
  
  private fun navigateTo(intent: Intent) = activity.startActivity(intent)
  
  private inline fun <reified T : BaseActivity> getIntent() = Intent(activity, T::class.java)
}

enum class ScreenType : Serializable {
  USER
}
