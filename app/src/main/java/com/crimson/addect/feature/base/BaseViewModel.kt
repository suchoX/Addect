package com.crimson.addect.feature.base

import android.databinding.BaseObservable
import android.os.Bundle

open class BaseViewModel<T : MvvmView> : BaseObservable(), ViewModel<T> {

  private lateinit var view: T
  private var resumed: Boolean = false

  fun getView(): T = view

  fun isResumed(): Boolean = resumed

  override fun attach() {

  }

  override fun attach(view: T) {
    this.view = view
  }

  override fun resume() {
    resumed = true
  }

  override fun pause() {
    resumed = false
  }

  override fun detach() {

  }

  override fun restoreInstanceState(savedInstanceState: Bundle?) {

  }

  override fun saveInstanceState(outState: Bundle?) {

  }
}