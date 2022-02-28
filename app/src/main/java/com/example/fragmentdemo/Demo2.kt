package com.example.fragmentdemo

import android.media.AudioTrack
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.fragmentdemo.databinding.FragmentDemo2Binding
import com.example.fragmentdemo.databinding.FragmentDemoBinding


class Demo2 : Fragment() {
    private var _binding: FragmentDemo2Binding? = null
    private val binding get() = _binding!!
    private lateinit var name: String
    private lateinit var track: String
    private lateinit var goals: String

    companion object{
        const val NAME = "name"
        const val TRACK = "track"
        const val GOALS = "goals"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME).toString()
            track = it.getString(TRACK).toString()
            goals = it.getString(GOALS).toString()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDemo2Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textview.text = name
        binding.trackview.text = track
        binding.goalview.text = goals
    }

}