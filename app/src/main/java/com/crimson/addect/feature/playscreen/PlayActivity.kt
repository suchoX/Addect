package com.crimson.addect.feature.playscreen

import com.crimson.addect.R
import com.crimson.addect.dagger.component.ActivityComponent
import com.crimson.addect.databinding.PlayActivityBinding
import com.crimson.addect.feature.base.BaseActivity

class PlayActivity : BaseActivity<PlayActivityBinding, PlayViewModel>() {
  override fun layoutId(): Int = R.layout.activity_play

  override fun onComponentCreated(activityComponent: ActivityComponent) {
    activityComponent.inject(this)
  }
}
