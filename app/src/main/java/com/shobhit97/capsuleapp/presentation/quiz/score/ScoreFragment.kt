package com.shobhit97.capsuleapp.presentation.quiz.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shobhit97.capsuleapp.R
import com.shobhit97.capsuleapp.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    private var _binding: FragmentScoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val args : ScoreFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.score.text = getString(R.string.total_score,args.score,args.total)
        binding.restartQuiz.setOnClickListener {
            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToQuizFragment())
        }
    }



}