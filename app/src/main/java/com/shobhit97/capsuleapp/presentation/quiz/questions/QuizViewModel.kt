package com.shobhit97.capsuleapp.presentation.quiz.questions

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor() : ViewModel() {
    private val _currentQuestionNumber = MutableStateFlow(0)
    val currentQuestionNumber: StateFlow<Int> = _currentQuestionNumber

    var totalQuestions = 0
    private var _score = 0


    private var countDownTimer: CountDownTimer? = null
    private val totalTimeInMillis: Long = 10000 // 10 seconds

    private val _timerStateFlow = MutableStateFlow(totalTimeInMillis / 1000)

    init {
        startTimer()
    }

    private fun startTimer() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timerStateFlow.value = millisUntilFinished / 1000
            }

            override fun onFinish() {
                moveToNextQuestion(totalQuestions)
            }
        }.start()
    }

    fun moveToNextQuestion(totalQuestions: Int) {
        if (_currentQuestionNumber.value < totalQuestions - 1) {
            _currentQuestionNumber.value++
            startTimer()
        } else {
            countDownTimer?.cancel()
        }
    }


    suspend fun observeTimer(): Flow<Long> = flow {
        while (true) {
            emit(_timerStateFlow.value)
            delay(1000)
        }

    }

    fun increaseScore() {
        _score++
    }

    fun getScore(): Int = _score

    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }

}