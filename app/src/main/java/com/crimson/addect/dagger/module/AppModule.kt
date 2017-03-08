package com.crimson.addect.dagger.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.crimson.addect.AddectApp

import com.crimson.addect.dagger.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides

@Module class AppModule(private val app: AddectApp) {

  @Provides @ApplicationContext internal fun provideContext(): Context {
    return app
  }

  internal val application: Application
    @Provides @ApplicationContext get() = app

  @Provides @ApplicationContext internal fun provideResources(): Resources {
    return app.resources
  }
}
