package com.dashkevich.bestshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dashkevich.bestshop.di.viewModelModule
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

        //WindowCompat.setDecorFitsSystemWindows(window, false)
        val wic = WindowInsetsControllerCompat(window, window.decorView)
        wic.isAppearanceLightStatusBars = true
        wic.isAppearanceLightNavigationBars = true

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