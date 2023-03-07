package com.dashkevich.bestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHost = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHost.navController
    }

    @Deprecated("Deprecated in Java", ReplaceWith("navController.popBackStack()"))
    override fun onBackPressed() {
        navController.popBackStack()
    }
}