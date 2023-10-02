package com.multti.nf.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.multti.nf.R
import com.multti.nf.databinding.ActivityConferenceBinding
import com.multti.nf.viewmodels.QRCodeViewModel

class ConferenceActivity : AppCompatActivity() {

    private val qrCodeViewModel: QRCodeViewModel by viewModels()

    private var nome: String = "Valor padrão" // Defina um valor padrão inicial
    private lateinit var binding: ActivityConferenceBinding // Declaração da variável de binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialize o binding
        binding = ActivityConferenceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Recupere o valor extra "baixaria" do Intent aqui dentro
        intent.getStringExtra("baixaria")?.let { result ->
            nome = result // Atribua o valor extra a 'nome' se não for nulo
        }

        val qrCode = qrCodeViewModel.codePartition(nome)
        binding.tvCnpj.text = qrCode.first
        binding.tvChave.text = qrCode.second
        binding.tvValor.text = qrCode.third
    }
}