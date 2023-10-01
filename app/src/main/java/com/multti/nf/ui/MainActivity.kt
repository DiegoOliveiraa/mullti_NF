package com.multti.nf.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import com.multti.nf.R


class MainActivity : AppCompatActivity() {




    private val barcodeLauncher: ActivityResultLauncher<ScanOptions> by lazy {
        registerForActivityResult(ScanContract()) { result ->
            registerResult(result)
        }
    }

    private val getbarcodeLauch = barcodeLauncher


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instrution_qrcode_fragment)

        findViewById<ExtendedFloatingActionButton>(R.id.button_read_qrcode).setOnClickListener {
            registerResult()
        }

    }

    private fun registerResult() {
        val options =
            ScanOptions().setDesiredBarcodeFormats(ScanOptions.QR_CODE) // Alterado para QR_CODE
                .setPrompt("Escaneie um código de barras").setCameraId(0).setBeepEnabled(true)
                .setOrientationLocked(true).setTorchEnabled(true)
        getbarcodeLauch.launch(options)
    }

    private fun registerResult(result: ScanIntentResult) {
        if (result.contents == null) {
            Toast.makeText(
                this@MainActivity, "Cancelado", Toast.LENGTH_LONG
            ).show()
        } else {
            val intent = Intent(this, ConferenceActivity::class.java)
            intent.putExtra(QR_CODE, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            startActivity(intent)
        }
    }
}
