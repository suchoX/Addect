package com.crimson.addect.dagger.component

import com.crimson.addect.utils.Resources
import com.crimson.addect.utils.SharedPrefs

interface ShareableAppComponent {
  fun provideAppPrefs(): SharedPrefs
  fun provideResources(): Resources
}
