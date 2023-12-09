package com.shobhit97.capsuleapp.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shobhit97.capsuleapp.presentation.notes.NotesFragment
import com.shobhit97.capsuleapp.presentation.quiz.questions.QuizFragment
import com.shobhit97.capsuleapp.presentation.quiz.quiz_container.QuizContainerFragment
import com.shobhit97.capsuleapp.presentation.quiz.start_quiz.StartQuizFragment
import com.shobhit97.capsuleapp.presentation.video.VideoFragment

class MainTabAdapter(fragmentActivity: FragmentActivity, private val totalTab:Int):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = totalTab

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> VideoFragment()
            1 -> NotesFragment()
            else -> QuizContainerFragment()
        }
    }
}