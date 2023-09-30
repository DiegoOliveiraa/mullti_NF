package com.multti.nf.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class QRCodeViewModel @Inject constructor() : ViewModel() {

    fun codePartition(input: String): Triple<String, String, String> {
        val regex = Regex("""^(\d{14})\|(\d{44})\|([\d.]+)$""")
        val matchResult = regex.matchEntire(input)
        val (Cnpj, chave, valor) = matchResult!!.destructured
        return Triple(Cnpj, chave, valor)
    }

}