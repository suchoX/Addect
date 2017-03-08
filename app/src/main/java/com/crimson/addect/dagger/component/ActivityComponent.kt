package com.crimson.addect.dagger.component

import com.crimson.addect.dagger.module.ActivityModule
import com.crimson.addect.dagger.scope.ActivityScope
import com.crimson.addect.feature.playscreen.PlayActivity
import com.crimson.addect.feature.startscreen.StartScreenActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

  fun inject(startScreenActivity: StartScreenActivity)

  fun inject(playActivity: PlayActivity)
}
