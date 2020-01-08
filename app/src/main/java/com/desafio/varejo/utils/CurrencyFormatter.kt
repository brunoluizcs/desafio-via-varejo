package com.desafio.varejo.utils

import java.text.NumberFormat
import java.util.*



class CurrencyFormatter {
    fun format(value: Float?): String {
        val v = value ?: 0.0
        val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return format.format(v)
    }
}