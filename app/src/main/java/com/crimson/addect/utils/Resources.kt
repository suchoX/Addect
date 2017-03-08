package com.crimson.addect.utils

import android.content.Context
import android.support.annotation.StringRes
import com.crimson.addect.dagger.qualifier.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class Resources @Inject constructor(@ApplicationContext val context: Context) {

  public fun getString(@StringRes id: Int): String = context.getString(id)
}
