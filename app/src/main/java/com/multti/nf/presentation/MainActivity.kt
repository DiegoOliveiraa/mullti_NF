package com.multti.nf.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.multti.nf.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonReadQRCode = findViewById<AppCompatButton>(R.id.button_read_qrcode)

        buttonReadQRCode.setOnClickListener {
            val intent = Intent(this, ReaderActivity::class.java)
            startActivity(intent)
        }
    }
}