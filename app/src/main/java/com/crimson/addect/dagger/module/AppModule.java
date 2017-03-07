package com.crimson.addect.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.crimson.addect.AddectApp;

import com.crimson.addect.dagger.qualifier.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module public final class AppModule {

  private final AddectApp app;

  public AppModule(AddectApp app) {
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
