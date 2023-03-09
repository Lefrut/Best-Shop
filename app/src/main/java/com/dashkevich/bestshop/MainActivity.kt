package com.dashkevich.bestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.dashkevich.dat.di.dataModule
import com.dashkevich.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(dataModule + domainModule)//+ viewModelModule
        }

        val navHost = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHost.navController
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}