package com.multti.nf.utils

fun String.makeFormatCnpj(): String {
    var maskedCnpj = "##.###.###/####-##"
    val onlyNumbers = this.replace(Regex("[^0-9]"), "")

    for (char in onlyNumbers) {
        maskedCnpj = maskedCnpj.replaceFirst("#", char.toString())
    }

    return maskedCnpj
}

fun String.makeFormatKey(): String {
    var maskedKey = "#### #### #### #### #### #### #### #### #### #### ####"
    val onlyNumbers = this.replace(Regex("[^0-9]"), "")

    for (char in onlyNumbers) {
        maskedKey = maskedKey.replaceFirst("#", char.toString())
    }

    return maskedKey
}

fun String.makeFormatCurrency(): String {
    val value = this.replace(",", ".").toDoubleOrNull() ?: 0.0
    return String.format("R$ %.2f", value).replace(".", ",")
}