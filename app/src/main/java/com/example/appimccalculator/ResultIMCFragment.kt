package com.example.appimccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appimccalculator.databinding.ActivityMainBinding
import com.example.appimccalculator.databinding.FragmentResultIMCBinding


class ResultIMCFragment : Fragment() {

    // Variable para almacenar la referencia del View Binding
    private var _binding: FragmentResultIMCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultIMCBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment

    }


}