package com.shobhit97.capsuleapp.presentation.quiz.start_quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shobhit97.capsuleapp.R
import com.shobhit97.capsuleapp.databinding.FragmentStartQuizBinding

class StartQuizFragment : Fragment() {
    private var _binding: FragmentStartQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStartQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startQuizBtn.setOnClickListener {
            findNavController().navigate(StartQuizFragmentDirections.actionStartQuizFragmentToQuizFragment())
        }
    }

}