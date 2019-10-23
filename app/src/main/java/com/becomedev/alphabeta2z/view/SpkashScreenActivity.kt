package com.becomedev.alphabeta2z.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.becomedev.alphabeta2z.R

class SpkashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spkash_screen)

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
