package com.multti.nf.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.multti.nf.R


class SoonActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soon_activity)

        Handler(Looper.getMainLooper()).postDelayed({
            val options = ActivityOptions.makeSceneTransitionAnimation(this@SoonActivity)
            val intent = Intent(this@SoonActivity, MainActivity::class.java)
            startActivity(intent,options.toBundle())
            finish()
        }, 3000)
    }

}
