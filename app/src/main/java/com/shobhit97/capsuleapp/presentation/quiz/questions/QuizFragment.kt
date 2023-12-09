package com.shobhit97.capsuleapp.presentation.quiz.questions

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shobhit97.capsuleapp.R
import com.shobhit97.capsuleapp.databinding.FragmentQuizBinding
import com.shobhit97.capsuleapp.util.questions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class QuizFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private var currentQuestionIndex = 0
    private var totalQuestions = 0
    private lateinit var navController: NavController
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setListeners()
        bindStateObserver()
        totalQuestions = questions.size
        viewModel.totalQuestions = totalQuestions

        binding.nextBtn.setOnClickListener {
            if (currentQuestionIndex < totalQuestions - 1) {
                viewModel.moveToNextQuestion(totalQuestions)
            } else {
                navController.navigate(QuizFragmentDirections.actionQuizFragmentToScoreFragment(viewModel.getScore() ,totalQuestions))
            }
        }

    }

    private fun setListeners() {
        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
    }

    private fun bindStateObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                launch {
                    viewModel.observeTimer().collect { timerValue ->
                        binding.timer.text = getString(R.string.timer, timerValue)
                    }
                }
                launch {
                    viewModel.currentQuestionNumber.collect { questionIndex ->
                        currentQuestionIndex = questionIndex
                        showQuestion(questionIndex)
                    }
                }
            }
        }
    }

    private fun showQuestion(index: Int) {
        binding.questionNumber.text = getString(R.string.current_question, index + 1)
        binding.question.text = questions[index].question
        binding.optionOne.text = questions[index].options[0]
        binding.optionTwo.text = questions[index].options[1]
        binding.optionThree.text = questions[index].options[2]
        binding.optionFour.text = questions[index].options[3]
        isEnabledButton(true)
        resetButtonBackground()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_one -> {
                checkAnswer(0, binding.optionOne)
            }

            R.id.option_two -> {
                checkAnswer(1, binding.optionTwo)

            }

            R.id.option_three -> {
                checkAnswer(2,binding.optionThree)
            }

            R.id.option_four -> {
                checkAnswer(3, binding.optionFour)
            }
        }
    }

    private fun checkAnswer(selectedAnswerIndex: Int, clickedOptionId: Button) {
        isEnabledButton(false)
        val correctAnswer = questions[currentQuestionIndex].answer
        if (selectedAnswerIndex == correctAnswer) {
            viewModel.increaseScore()
            clickedOptionId.setBackgroundColor(Color.GREEN)
        } else {
            clickedOptionId.setBackgroundColor(Color.RED)
            when(correctAnswer) {
                0 ->  binding.optionOne.setBackgroundColor(Color.GREEN)
                1 -> binding.optionTwo.setBackgroundColor(Color.GREEN)
                2 -> binding.optionThree.setBackgroundColor(Color.GREEN)
                else -> binding.optionFour.setBackgroundColor(Color.GREEN)
            }
        }
    }

    private fun resetButtonBackground() {
        binding.optionOne.setBackgroundColor(requireContext().getColor(R.color.primary_blue))
        binding.optionTwo.setBackgroundColor(requireContext().getColor(R.color.primary_blue))
        binding.optionThree.setBackgroundColor(requireContext().getColor(R.color.primary_blue))
        binding.optionFour.setBackgroundColor(requireContext().getColor(R.color.primary_blue))
    }

    private fun isEnabledButton(value:Boolean) {
        binding.optionOne.isClickable = value
        binding.optionTwo.isClickable = value
        binding.optionThree.isClickable = value
        binding.optionFour.isClickable = value
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
