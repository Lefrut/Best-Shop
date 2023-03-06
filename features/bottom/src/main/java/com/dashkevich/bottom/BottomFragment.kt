package com.dashkevich.bottom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dashkevich.bottom.databinding.FragmentBottomBinding


class BottomFragment : Fragment(R.layout.fragment_bottom) {

    lateinit var binding: FragmentBottomBinding
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBottomBinding.bind(view)


        val navHost = childFragmentManager
            .findFragmentById(R.id.bottom_container) as NavHostFragment
        navController = navHost.navController

        binding.bottomNav.setupWithNavController(navController)
    }

}