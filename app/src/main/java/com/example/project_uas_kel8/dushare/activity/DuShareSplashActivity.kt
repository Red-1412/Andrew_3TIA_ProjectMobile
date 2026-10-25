package com.example.project_uas_kel8.dushare.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.project_uas_kel8.databinding.ActivityDushareSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DuShareSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDushareSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDushareSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.splashRoot) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        lifecycleScope.launch {
            delay(2000)
            val nextIntent = if (isLogin) {
                Intent(this@DuShareSplashActivity, DuShareMainActivity::class.java)
            } else {
                Intent(this@DuShareSplashActivity, DuShareLoginActivity::class.java)
            }
            startActivity(nextIntent)
            finish()
        }
    }
}
