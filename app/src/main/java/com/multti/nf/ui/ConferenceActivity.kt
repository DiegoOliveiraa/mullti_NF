package com.multti.nf.ui

import android.os.Bundle
import android.text.Editable
import android.text.Editable.Factory.getInstance
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.multti.nf.databinding.ActivityConferenceBinding
import com.multti.nf.utils.makeFormatCnpj
import com.multti.nf.utils.makeFormatCurrency
import com.multti.nf.utils.makeFormatKey
import com.multti.nf.viewmodels.QRCodeViewModel

const val QR_CODE = "QR_CODE"

class ConferenceActivity : AppCompatActivity() {

    private val qrCodeViewModel: QRCodeViewModel by viewModels()
    private lateinit var binding: ActivityConferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViews()
        setUpActions()
    }

    private fun setUpViews() {
        binding = ActivityConferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra(QR_CODE)?.let { result ->
            qrCodeViewModel.codePartition(result).apply {
                with(binding) {
                    editTextCnpj.text = getInstance().newEditable(first.makeFormatCnpj())
                    editTextKey.text = getInstance().newEditable(second.makeFormatKey())
                    editTextValue.text = getInstance().newEditable(third.makeFormatCurrency())
                }
            }
        }
    }

    private fun setUpActions() {
        binding.appCompatButton.setOnClickListener {
            finish()
        }
    }
}