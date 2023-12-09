package com.shobhit97.capsuleapp.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shobhit97.capsuleapp.databinding.FragmentNotesBinding
import com.shobhit97.capsuleapp.domain.model.Notes
import com.shobhit97.capsuleapp.util.notes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    private var notesAdapter: NotesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindRecyclerView()
    }

    private fun bindRecyclerView() {
        notesAdapter = NotesAdapter()
        binding.notesRv.apply {
            adapter = notesAdapter
            setHasFixedSize(true)
        }
        notesAdapter?.submitList(notes)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}