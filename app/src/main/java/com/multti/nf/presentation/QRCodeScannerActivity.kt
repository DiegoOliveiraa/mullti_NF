package com.multti.nf.presentation

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import com.journeyapps.barcodescanner.CaptureManager
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.multti.nf.R

class QRCodeScannerActivity : AppCompatActivity() {

    private lateinit var barcodeView: DecoratedBarcodeView
    private lateinit var captureManager: CaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_scanner)

        barcodeView = findViewById(R.id.camera_preview)
        captureManager = CaptureManager(this, barcodeView)

        // Solicitar permissão para acessar a câmera (se necessário)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
        } else {
            // Permissão já concedida, inicialize a câmera
            setupCamera()
        }
    }

    override fun onResume() {
        super.onResume()
        captureManager.onResume()
        captureManager.decode()
    }

    override fun onPause() {
        super.onPause()
        captureManager.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida, inicialize a câmera
                setupCamera()
            } else {
                // Permissão negada, trate conforme necessário
            }
        }
    }

    private fun setupCamera() {
        captureManager.initializeFromIntent(intent, null)
        captureManager.decode()
    }

    // Função para processar o resultado do QR Code
    private fun processQRCodeResult(result: Result) {
        val qrCodeText = result.text
        Toast.makeText(this, "QR Code lido: $qrCodeText", Toast.LENGTH_SHORT).show()
    }
}