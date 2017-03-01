package com.crimson.addet.feature.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.crimson.addet.BR
import com.crimson.addet.dagger.DaggerComponentManager
import com.crimson.addet.dagger.component.ActivityComponent
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, V : ViewModel<MvvmView>> : AppCompatActivity() {

  @Inject lateinit protected var viewModel: V
  @Inject lateinit var name: String

  lateinit var binding: B

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    onComponentCreated(DaggerComponentManager.getActivityComponent(this))
    bindContentView(layoutId())
  }

  fun bindContentView(layoutId: Int) {
    binding = DataBindingUtil.setContentView(this, layoutId)
    if (this is MvvmView) {
      viewModel.attach(this)
    }
    viewModel.attach()

    binding.setVariable(BR.viewModel, viewModel)
  }

  override fun onResume() {
    super.onResume()

    viewModel.resume()
  }

  override fun onPause() {
    super.onPause()
    viewModel.pause()
  }

  override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
    super.onSaveInstanceState(outState, outPersistentState)

    viewModel.saveInstanceState(outState)
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    super.onRestoreInstanceState(savedInstanceState)

    viewModel.restoreInstanceState(savedInstanceState)
  }

  override fun onDestroy() {
    super.onDestroy()

    viewModel.detach()
  }

  @LayoutRes protected abstract fun layoutId(): Int

  protected abstract fun onComponentCreated(activityComponent: ActivityComponent)
}