package com.crimson.addet

import android.app.Application
import android.util.Log
import com.crimson.addet.dagger.DaggerComponentManager

class AddetApp : Application() {
  override fun onCreate() {
    super.onCreate()
    Log.d("=====","Application")
    DaggerComponentManager.init(this)
  }
}
