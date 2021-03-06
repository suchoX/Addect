package com.crimson.addect.model

data class SumObject(val firstNumber: Int, val secondNumber: Int, val answer: Int,
    val rightAnswer: Boolean = true) {
  override fun toString(): String {
    return firstNumber.toString() + " + " + secondNumber.toString() + " = " +answer.toString()
  }
}