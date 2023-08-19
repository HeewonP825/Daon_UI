package com.daon.daon_ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.daon.daon_ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewTreeObserver.OnPreDrawListener {

    private lateinit var binding: ActivityMainBinding

    private val splashContent by lazy { findViewById<View>(android.R.id.content) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        splashContent.viewTreeObserver.addOnPreDrawListener(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Status Bar & Navigation Bar */
        val barColor = ContextCompat.getColor(this, R.color.white)
        with(window) {
            statusBarColor = barColor
            navigationBarColor = barColor
        }
        with(WindowInsetsControllerCompat(window, window.decorView)) {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_allMeeting, R.id.navigation_allFeed, R.id.navigation_myPage
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.apply {
            setBackgroundDrawable(ContextCompat.getDrawable(this@MainActivity, R.color.white))
            //val customTypeface = Typeface.createFromAsset(font, kotra_bold.otf)
            title = "다온" // 원하는 타이틀 설정
            //setTitle(ContextCompat.getColor(this@MainActivity, R.color.mainColor))
        }
        navView.setupWithNavController(navController)
    }

    override fun onPreDraw(): Boolean {
        return true
    }
}