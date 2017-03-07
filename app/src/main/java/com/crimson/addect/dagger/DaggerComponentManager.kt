package com.crimson.addect.dagger

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.crimson.addect.AddectApp
import com.crimson.addect.dagger.component.ActivityComponent
import com.crimson.addect.dagger.component.AppComponent
import com.crimson.addect.dagger.component.DaggerActivityComponent
import com.crimson.addect.dagger.component.DaggerAppComponent
import com.crimson.addect.dagger.module.ActivityModule
import com.crimson.addect.dagger.module.AppModule

object DaggerComponentManager {
  var component: AppComponent? = null
    private set

  fun init(app: AddectApp) {
    if (component != null) return
    component = DaggerAppComponent.builder().appModule(AppModule(app)).build()
    component?.inject(app)
  }

  fun getActivityComponent(activity: AppCompatActivity): ActivityComponent {
    return DaggerActivityComponent.builder()
        .appComponent(component)
        .activityModule(ActivityModule(activity))
        .build()
  }
}
