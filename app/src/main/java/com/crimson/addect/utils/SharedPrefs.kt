package com.crimson.addect.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.crimson.addect.dagger.qualifier.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class SharedPrefs @Inject constructor(@ApplicationContext context: Context) {
  private val PREFS_RATING_COUNT = "Show rating count"
  private val PREFS_SHOW_RATING = "Show Rating"

  private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

  fun showRatingDialog(): Boolean = prefs.getBoolean(PREFS_SHOW_RATING, true)

  fun setShowRatingDialog(show: Boolean) {
    prefs.edit().putBoolean(PREFS_SHOW_RATING, show).apply()
  }

  fun getRatingCount(): Int = prefs.getInt(PREFS_RATING_COUNT, 0)

  fun setRatingCount(count: Int) {
    prefs.edit().putInt(PREFS_RATING_COUNT, count).apply()
  }
}
