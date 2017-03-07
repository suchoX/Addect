package com.crimson.addect.feature.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.crimson.addect.BR
import com.crimson.addect.R
import com.crimson.addect.dagger.DaggerComponentManager
import com.crimson.addect.dagger.component.ActivityComponent
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, V : ViewModel<MvvmView>> : AppCompatActivity() {

  @Inject lateinit protected var viewModel: V

  lateinit var binding: B

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    fullScreen()
    onComponentCreated(DaggerComponentManager.getActivityComponent(this))
    bindContentView(layoutId())
  }

  fun fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
  }
  override fun attachBaseContext(newBase: Context?) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
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

  override fun onBackPressed() {
    finish()
    overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out)
  }
}