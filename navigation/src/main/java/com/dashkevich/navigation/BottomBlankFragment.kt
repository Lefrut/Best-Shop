package com.dashkevich.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class BottomBlankFragment : Fragment(R.layout.fragment_bottom_blank) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread.sleep(10)
        findNavController().navigate(R.id.action_bottomBlankFragment_to_home)
    }
}