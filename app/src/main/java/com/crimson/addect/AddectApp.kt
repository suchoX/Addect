package com.crimson.addect

import android.app.Application
import android.util.Log
import com.crimson.addect.dagger.DaggerComponentManager
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class AddectApp : Application() {
  override fun onCreate() {
    super.onCreate()
    DaggerComponentManager.init(this)
    if (BuildConfig.ENABLE_LOGGING) {
      Timber.plant(Timber.DebugTree())
    }

    CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/blogger_sans.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build())
  }
}
