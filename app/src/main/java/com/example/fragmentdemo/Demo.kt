package com.example.fragmentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.fragmentdemo.databinding.FragmentDemoBinding


class Demo : Fragment() {

private var _binding: FragmentDemoBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDemoBinding.inflate(inflater, container, false)
        navCon = NavController(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = binding.text1.editText?.text.toString()
        val track = binding.text2.editText?.text.toString()
        val goals = binding.text3.editText?.text.toString()
        val action = DemoDirections.actionDemoToDemo2(name, track, goals)

        binding.button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", binding.text1.editText?.text.toString())
            bundle.putString("track", binding.text2.editText?.text.toString())
            bundle.putString("goals", binding.text3.editText?.text.toString())
            navCon.navigate(R.id.action_demo_to_demo2, bundle)
        }
    }
}