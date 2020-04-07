package com.demo.urbandictionary.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toolbar
import com.demo.urbandictionary.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    supportActionBar?.hide()
    showSplash()

  }

  fun showSplash(){
    Handler().postDelayed({
      startActivity(
        Intent(this,MainActivity::class.java)
      )
      finish()
    },3000)
  }


}
