package com.dashkevich.bestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.dashkevich.dat.di.dataModule
import com.dashkevich.domain.di.domainModule
import com.dashkevich.home.di.viewModelModule
import com.dashkevich.home.page1.Page1ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(dataModule + domainModule + viewModelModule)
        }
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHost.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}