package com.crimson.addet.feature.base

import android.os.Bundle

interface ViewModel<T : MvvmView> {

  fun attach()

  fun attach(view: T)

  fun resume()

  fun pause()

  fun detach()

  fun restoreInstanceState(savedInstanceState: Bundle?)

  fun saveInstanceState(outState: Bundle?)
}
