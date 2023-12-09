package com.shobhit97.capsuleapp.presentation.video

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import com.shobhit97.capsuleapp.R
import com.shobhit97.capsuleapp.databinding.FragmentVideoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private var _binding:FragmentVideoBinding? = null
    private val binding get() = _binding!!

    private lateinit var videoView: VideoView
    private lateinit var mediaController: MediaController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVideoBinding.inflate(inflater,container,false)
        videoView = binding.videoView
        mediaController = MediaController(context)

        val path = "android.resource://" + requireContext().packageName + "/" + R.raw.android
        val uri = Uri.parse(path)
        videoView.setVideoURI(uri)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoView.start()
    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
    }

    override fun onResume() {
        super.onResume()
        videoView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.stopPlayback()
        _binding = null
    }


}