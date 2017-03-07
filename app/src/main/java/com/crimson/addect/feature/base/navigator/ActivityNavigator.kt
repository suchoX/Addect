package com.crimson.addect.feature.base.navigator

import android.support.v7.app.AppCompatActivity

class ActivityNavigator constructor(private val activity: AppCompatActivity) : Navigator() {

  override fun getActivity(): AppCompatActivity = activity


}