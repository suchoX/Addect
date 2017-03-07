package com.crimson.addect.feature.base.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity

abstract class Navigator {
  abstract fun getActivity(): AppCompatActivity

  fun startActivityWithAnimation(activityClass: Class<out AppCompatActivity>,
      inAnimation: Int, outAnimation: Int) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    activity.startActivity(intent)
    getActivity().overridePendingTransition(inAnimation, outAnimation)
  }

}