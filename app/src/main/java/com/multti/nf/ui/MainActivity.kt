package com.multti.nf.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.multti.nf.R

class MainActivity : AppCompatActivity() {

    private val barcodeLauncher: ActivityResultLauncher<ScanOptions> by lazy {
        registerForActivityResult(ScanContract()) { result ->
            if (result.contents == null) {
                Toast.makeText(this@MainActivity, "Cancelado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Escaneado: " + result.contents,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instrution_qrcode_fragment)
        val options = ScanOptions()
            .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
            .setPrompt("Escaneie um código de barras")
            .setCameraId(0)
            .setBeepEnabled(true)
            .setOrientationLocked(false)
        barcodeLauncher.launch(options)
//        val button = findViewById<ExtendedFloatingActionButton>(R.id.button_read_qrcode)
//        button.setOnClickListener {
//            val options = ScanOptions()
//                .setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES)
//                .setPrompt("Escaneie um código de barras")
//                .setCameraId(0)
//                .setBeepEnabled(true)
//            barcodeLauncher.launch(options)
//        }
    }
}
