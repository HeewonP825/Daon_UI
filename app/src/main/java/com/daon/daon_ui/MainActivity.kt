package com.daon.daon_ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
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

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, ViewTreeObserver.OnPreDrawListener {

    private val splashContent by lazy { findViewById<View>(android.R.id.content) }

    private lateinit var binding: ActivityMainBinding

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
        // 폰트 파일 로드
        //val customTypeface = Typeface.createFromAsset(assets, "@font/kotra_bold.otf")

        //액션바 커스터마이즈
//        supportActionBar?.apply {
//            setBackgroundDrawable(ContextCompat.getDrawable(this@MainActivity, R.color.white))
//            title = "다온" // 원하는 타이틀 설정
//            val titleTextView = findViewById<TextView>(resources.getIdentifier("action_bar_title", "id", packageName))
//            titleTextView?.apply {
//                setTextColor(ContextCompat.getColor(this@MainActivity, R.color.mainColor)) // 색 설정
//            }
//        }
        navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }
    }

    override fun onPreDraw(): Boolean {
        return true
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                setToolbarTitle("다온") // 원하는 타이틀 설정
                updateToolbarButton(R.drawable.ic_home_toolbar_btn, "고객센터")
                navigateToFragment(R.id.navigation_home) // 프래그먼트 이동
                return true
            }
            R.id.navigation_allMeeting -> {
                setToolbarTitle("모임")
                updateToolbarButton(R.drawable.ic_feed_toolbar_btn, "새 모임 만들기")
                navigateToFragment(R.id.navigation_allMeeting)
                return true
            }
            R.id.navigation_allFeed -> {
                setToolbarTitle("피드")
                updateToolbarButton(R.drawable.ic_feed_toolbar_btn, "새 피드 작성")
                navigateToFragment(R.id.navigation_allFeed)
                return true
            }
            R.id.navigation_myPage -> {
                setToolbarTitle("내정보")
                updateToolbarButton(0, "내 정보 수정")
                navigateToFragment(R.id.navigation_myPage)
                return true
            }
        }
        return false
    }

    private fun setToolbarTitle(title: String) {
        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.text = title
    }

    private fun navigateToFragment(itemId: Int) {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigate(itemId)
    }

    fun updateToolbarButton(iconResId: Int, buttonText: String) {
        val buttonIcon = findViewById<ImageView>(R.id.button_icon)
        val buttonTextview = findViewById<TextView>(R.id.button_text)

        buttonIcon.setImageResource(iconResId)
        buttonTextview.text = buttonText
    }

}