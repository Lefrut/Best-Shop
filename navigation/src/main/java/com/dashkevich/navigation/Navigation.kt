package com.dashkevich.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


fun Fragment.findRootNavController(): NavController {
    val host = requireActivity()
        .supportFragmentManager.findFragmentById(
            com.dashkevich.navigation.R.id.main_container
        ) as NavHostFragment?
    return host?.navController ?: findNavController()
}