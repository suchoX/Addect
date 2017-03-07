package com.crimson.addect.dagger.component;

import com.crimson.addect.AddectApp;
import com.crimson.addect.dagger.module.AppModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent extends ShareableAppComponent {
  void inject(AddectApp app);
}
