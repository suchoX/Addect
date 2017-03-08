package com.crimson.addect.dagger.module

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.crimson.addect.dagger.qualifier.ActivityContext
import com.crimson.addect.dagger.scope.ActivityScope
import com.crimson.addect.feature.base.navigator.ActivityNavigator
import com.crimson.addect.feature.base.navigator.Navigator
import dagger.Module
import dagger.Provides

@Module class ActivityModule(private val activity: AppCompatActivity) {

  @Provides @ActivityContext fun provideActivityContext(): Context {
    return activity
  }

  @Provides internal fun provideActivity(): Activity {
    return activity
  }

  @Provides @ActivityScope internal fun provideNavigator(): Navigator {
    return ActivityNavigator(activity)
  }
}
