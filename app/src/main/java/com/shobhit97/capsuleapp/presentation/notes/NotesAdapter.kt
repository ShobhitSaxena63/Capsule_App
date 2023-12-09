package com.shobhit97.capsuleapp.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shobhit97.capsuleapp.databinding.NoteItemBinding
import com.shobhit97.capsuleapp.domain.model.Notes

class NotesAdapter : ListAdapter<Notes, NotesAdapter.ViewHolder>(DIFF_UTIL) {
    inner class ViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Notes) {
            binding.title.text = note.title
            binding.description.text = note.description
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Notes>() {
            override fun areItemsTheSame(
                oldItem: Notes, newItem: Notes
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Notes, newItem: Notes
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}