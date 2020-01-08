package com.desafio.varejo.utils

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CurrencyFormatterTest{

    @Test
    fun `convert_valid_value_test`(){
        val value = CurrencyFormatter().format(1999.35f)
        assertEquals("O valor formatado não coincide","R$ 1.999,35",value)
    }

    @Test
    fun `convert_null_value_test`(){
        val value = CurrencyFormatter().format(null)
        assertEquals("O valor formatado não coincide","R$ 0,00",value)
    }
}