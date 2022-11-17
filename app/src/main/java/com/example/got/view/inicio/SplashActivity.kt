package com.example.got.view.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.got.R
import com.example.got.view.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val image = findViewById<ImageView>(R.id.iv_splash)
        image.alpha = 0f
        image.animate().setDuration(2500).alpha(1f).withEndAction {
            val it = Intent(this, HomeActivity::class.java)
            startActivity(it)
            overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            finish()
        }
    }
}
