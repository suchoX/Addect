package com.crimson.addet.dagger.component;

import com.crimson.addet.dagger.module.ActivityModule;
import com.crimson.addet.dagger.scope.ActivityScope;
import com.crimson.addet.feature.startscreen.StartScreenActivity;
import dagger.Component;
import org.jetbrains.annotations.NotNull;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = { ActivityModule.class })
public interface ActivityComponent {

  void inject(@NotNull StartScreenActivity startScreenActivity);
}
