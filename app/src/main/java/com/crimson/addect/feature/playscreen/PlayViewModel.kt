package com.crimson.addect.feature.playscreen

import com.crimson.addect.R
import com.crimson.addect.feature.base.BaseViewModel
import com.crimson.addect.feature.base.MvvmView
import com.crimson.addect.model.SumObject
import com.crimson.addect.utils.Resources
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.Random
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

open class PlayViewModel @Inject constructor() : BaseViewModel<MvvmView>() {

  @Inject lateinit var resources: Resources
  private var score: Int = 0
  private var highScore: Int = 0
  private val random: Random = Random()
  private lateinit var sumText: String
  private lateinit var sum: SumObject

  override fun attach() {
    super.attach()
    sumText = resources.getString(R.string.get_ready)
    notifyChange()
    setQuestionTimer()
  }

  private fun setQuestionTimer() {
    Observable.interval(3, SECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { generateSumObject() }
  }

  private fun generateSumObject() {
    var firstNumber = random.nextInt(1000 + 1)
    if (score > 10) {
      firstNumber %= 15
    } else {
      firstNumber %= 10
    }

    var secondNumber = random.nextInt(1000 + 1)
    if (score > 10) {
      secondNumber %= 15
    } else {
      secondNumber %= 10
    }
    if (generateRightAnswer()) {
      sum = SumObject(firstNumber, secondNumber, firstNumber + secondNumber, true)
    } else {
      sum = generateWrongAnswer(firstNumber, secondNumber)
    }
    sumText = sum.toString()
    notifyChange()
  }

  private fun generateRightAnswer(): Boolean = random.nextBoolean()

  private fun generateWrongAnswer(firstNumber: Int, secondNumber: Int): SumObject {
    val moreThanActualAnswer = random.nextBoolean()
    val difference = random.nextInt(1000) % 6
    if (moreThanActualAnswer) {
      return SumObject(firstNumber, secondNumber, firstNumber + secondNumber + difference, false)
    } else {
      val answer = firstNumber + secondNumber
      if (answer - difference > 0) {
        return SumObject(firstNumber, secondNumber, firstNumber + secondNumber - difference, false)
      } else {
        return generateWrongAnswer(firstNumber, secondNumber)
      }
    }
  }

  fun getSumText(): String = sumText

  fun getHighScore(): String = highScore.toString()
}