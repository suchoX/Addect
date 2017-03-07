package com.crimson.addect.feature.startscreen

import com.crimson.addect.R
import com.crimson.addect.feature.base.BaseViewModel
import com.crimson.addect.feature.base.MvvmView
import com.crimson.addect.feature.base.navigator.Navigator
import com.crimson.addect.feature.playscreen.PlayActivity
import timber.log.Timber
import javax.inject.Inject

open class StartScreenViewModel @Inject constructor() : BaseViewModel<MvvmView>() {

  @Inject lateinit var navigator : Navigator

  fun startGame() = navigator.startActivityWithAnimation(PlayActivity::class.java, R.anim.slide_left_in, R.anim.slide_left_out)

  fun showAchievements() {
    Timber.d("Show Achievements")
  }

  fun showLeaderBoards() {
    Timber.d("Show LeaderBoards")
  }
}