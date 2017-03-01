package com.crimson.addet.feature.startscreen

import com.crimson.addet.R
import com.crimson.addet.dagger.component.ActivityComponent
import com.crimson.addet.databinding.StartScreenActivityBinding
import com.crimson.addet.feature.base.BaseActivity

class StartScreenActivity : BaseActivity<StartScreenActivityBinding, StartScreenViewModel>() {

  override fun layoutId(): Int  = R.layout.activity_start_screen

  override fun onComponentCreated(activityComponent: ActivityComponent) {
    activityComponent.inject(this)
  }
}
