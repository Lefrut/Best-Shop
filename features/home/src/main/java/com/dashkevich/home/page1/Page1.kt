package com.dashkevich.home.page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.dashkevich.home.R
import com.dashkevich.home.databinding.FragmentPage1Binding

class Page1 : Fragment(R.layout.fragment_page1) {

    lateinit var binding: FragmentPage1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPage1Binding.bind(view)

    }
}