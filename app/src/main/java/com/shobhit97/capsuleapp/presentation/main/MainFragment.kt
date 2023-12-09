package com.shobhit97.capsuleapp.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.shobhit97.capsuleapp.R
import com.shobhit97.capsuleapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    private lateinit var tabItems: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        tabItems = listOf(
            getString(R.string.video),
            getString(R.string.notes),
            getString(R.string.quiz)
        )
        bindViewPager()
        bindTabLayoutClick()
    }


    private fun bindViewPager() {
        binding.viewPager.apply {
            adapter = MainTabAdapter(requireActivity(),tabItems.size)
        }
    }

    private fun bindTabLayoutClick() {
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position -> // Styling each tab here
            tab.text = tabItems[position]
        }.attach()
    }


}