package com.example.recucle_view1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        Handler().postDelayed({
            val i = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)

    }
}