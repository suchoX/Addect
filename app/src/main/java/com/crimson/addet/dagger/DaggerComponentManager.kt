package com.crimson.addet.dagger

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.crimson.addet.AddetApp
import com.crimson.addet.dagger.component.ActivityComponent
import com.crimson.addet.dagger.component.AppComponent
import com.crimson.addet.dagger.component.DaggerActivityComponent
import com.crimson.addet.dagger.component.DaggerAppComponent
import com.crimson.addet.dagger.module.ActivityModule
import com.crimson.addet.dagger.module.AppModule

object DaggerComponentManager {
  var component: AppComponent? = null
    private set

  fun init(app: AddetApp) {
    if (component != null) return
    component = DaggerAppComponent.builder().appModule(AppModule(app)).build()
    Log.d("=====","DaggerComponentManager:Init")
    (component as AppComponent?)?.inject(app)
  }

  fun getActivityComponent(activity: AppCompatActivity): ActivityComponent {
    Log.d("=====","getActivityComponent")
    return DaggerActivityComponent.builder()
        .appComponent(component)
        .activityModule(ActivityModule(activity))
        .build()
  }
}
