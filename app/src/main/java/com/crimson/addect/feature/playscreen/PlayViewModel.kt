package com.crimson.addect.feature.playscreen

import com.crimson.addect.feature.base.BaseViewModel
import com.crimson.addect.feature.base.MvvmView
import com.crimson.addect.model.SumObject
import java.util.Random
import javax.inject.Inject

open class PlayViewModel @Inject constructor() : BaseViewModel<MvvmView>() {

  private var score: Int = 0
  private var highScore: Int = 0
  private val random: Random = Random()
  private var sumText = ""
  private lateinit var sum: SumObject

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
  }

  private fun rightOrWrongAnswer() : Boolean = random.nextBoolean()

  private fun generateWrongAnswer(firstNumber: Int, secondNumber : Int) {

  }
}