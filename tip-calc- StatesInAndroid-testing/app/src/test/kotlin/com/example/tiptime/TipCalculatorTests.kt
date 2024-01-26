package com.example.tiptime

import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals


class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val roundUp = false
        val actualTip = calculateTip(amount, tipPercent, roundUp)
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        assertEquals(expectedTip, actualTip)
    }

    private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp :Boolean): String {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            return NumberFormat.getCurrencyInstance().format(kotlin.math.ceil(tip))
        }
        else {
            return NumberFormat.getCurrencyInstance().format(tip)
        }
    }

}