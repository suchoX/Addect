package com.crimson.addet.dagger.component;

import com.crimson.addet.AddetApp;
import com.crimson.addet.dagger.module.AppModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent {
  void inject(AddetApp app);
}
