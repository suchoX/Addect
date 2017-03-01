package com.crimson.addet.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.crimson.addet.AddetApp;

import com.crimson.addet.dagger.qualifier.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module public final class AppModule {

  private final AddetApp app;

  public AppModule(AddetApp app) {
    this.app = app;
  }

  @Provides @ApplicationContext Context provideContext() {
    return app;
  }

  @Provides @ApplicationContext Application getApplication() {
    return app;
  }

  @Provides @ApplicationContext Resources provideResources() {
    return app.getResources();
  }
}
