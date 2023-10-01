package com.multti.nf.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.multti.nf.R
import com.multti.nf.viewmodels.QRCodeViewModel

const val QR_CODE = "QR_CODE"

class ConferenceActivity : AppCompatActivity() {

    private val qrCodeViewModel: QRCodeViewModel by viewModels()

    val nome = intent.getStringExtra(QR_CODE)?: "Valor padrão"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference)


//        nome?.let { result ->
//            val codePartition = qrCodeViewModel.codePartition(result)
//            Toast.makeText(this, codePartition.toString(), Toast.LENGTH_SHORT).show()
//        }
    }
}