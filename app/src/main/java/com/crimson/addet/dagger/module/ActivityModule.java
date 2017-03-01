package com.crimson.addet.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.crimson.addet.dagger.qualifier.ActivityContext;
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
  @Provides String provideName() {
    return "ABC";
  }
}
