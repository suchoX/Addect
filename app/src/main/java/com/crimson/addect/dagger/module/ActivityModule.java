package com.crimson.addect.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.crimson.addect.dagger.qualifier.ActivityContext;
import com.crimson.addect.dagger.scope.ActivityScope;
import com.crimson.addect.feature.base.navigator.ActivityNavigator;
import com.crimson.addect.feature.base.navigator.Navigator;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {
  private final AppCompatActivity activity;

  public ActivityModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides @ActivityContext public Context provideActivityContext() {
    return activity;
  }

  @Provides Activity provideActivity() {
    return activity;
  }

  @Provides @ActivityScope Navigator provideNavigator() { return new ActivityNavigator(activity) ; }
}
