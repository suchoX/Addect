package com.crimson.addect.feature.startscreen

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.crimson.addect.R
import com.crimson.addect.dagger.component.ActivityComponent
import com.crimson.addect.databinding.StartScreenActivityBinding
import com.crimson.addect.feature.base.BaseActivity
import com.crimson.addect.utils.SharedPrefs
import com.crimson.addect.utils.Constants
import javax.inject.Inject


class StartScreenActivity : BaseActivity<StartScreenActivityBinding, StartScreenViewModel>(), StartscreenView {
  private val RATING_DIALOG_MAX_FREQUENCY = 10

  @Inject lateinit var sharedPrefs: SharedPrefs

  override fun layoutId(): Int = R.layout.activity_start_screen

  override fun onComponentCreated(activityComponent: ActivityComponent) {
    activityComponent.inject(this)
    showRatingDialog()
  }

  fun showRatingDialog() {
    if (sharedPrefs.showRatingDialog()) {
      val count = sharedPrefs.getRatingCount()
      if (count == RATING_DIALOG_MAX_FREQUENCY) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.like_us)
            .setCancelable(true)
            .setPositiveButton(R.string.rate, { _, _ ->
              val uri = Uri.parse(Constants.APP_MARKET_LINK)
              val goToMarket = Intent(Intent.ACTION_VIEW, uri)
              try {
                startActivity(goToMarket)
              } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(
                        Constants.APP_URL_LINK)))
              }
              sharedPrefs.setShowRatingDialog(false)
            })
            .setNegativeButton(R.string.cancel, { _, _ -> })
            .create()
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
        sharedPrefs.setRatingCount(0)
      } else {
        sharedPrefs.setRatingCount(count + 1)
      }
    }
  }

}

