package com.crimson.addect.dagger.component;

import com.crimson.addect.dagger.module.ActivityModule;
import com.crimson.addect.dagger.scope.ActivityScope;
import com.crimson.addect.feature.playscreen.PlayActivity;
import com.crimson.addect.feature.startscreen.StartScreenActivity;
import dagger.Component;
import org.jetbrains.annotations.NotNull;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = { ActivityModule.class })
public interface ActivityComponent {

  void inject(@NotNull StartScreenActivity startScreenActivity);

  void inject(@NotNull PlayActivity playActivity);
}
