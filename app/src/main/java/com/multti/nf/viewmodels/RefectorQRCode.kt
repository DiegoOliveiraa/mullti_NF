package com.multti.nf.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RefectorQRCode @Inject constructor() : ViewModel() {

    fun codePartition(input: String): Triple<String, String, String> {
        val regex = Regex("""^(\d{14})\|(\d{44})\|([\d.]+)$""")
        val matchResult = regex.matchEntire(input)
        val (cnpj, chave, valor) = matchResult!!.destructured
        return Triple(cnpj, chave, valor)
    }

}