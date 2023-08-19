package com.daon.daon_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.constraintlayout.widget.ConstraintLayout
import com.daon.daon_ui.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // 스플래시 화면 클릭 시 메인 액티비티로 이동
        findViewById<ConstraintLayout>(R.id.splash_activity).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            handler?.removeCallbacksAndMessages(null)
        }

        // 스플래시 화면 디스플레이 시간 조절 (예: 2000 밀리초, 즉 2초)
        setInitialize(2000)
    }

    private fun setInitialize(delayMillis: Long) {
        handler = Handler(Looper.getMainLooper())
        handler?.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, delayMillis)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacksAndMessages(null)
    }

    // ...
}