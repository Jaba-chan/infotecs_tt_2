package ru.evgenykuzakov.infotecs_tt_2

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class NativeCalcInstrumentedTest {

    companion object {
        init {
            System.loadLibrary("infotecs_tt_2")
        }
    }

    private val calc = NativeCalc()

    @Test
    fun testPlus() {
        assertEquals(4.0, calc.plus(2.0, 2.0), 0.000001)
    }

    @Test
    fun testMinus() {
        assertEquals(0.0, calc.minus(2.0, 2.0), 0.000001)
    }

    @Test
    fun testMultiply() {
        assertEquals(6.0, calc.multiply(2.0, 3.0), 0.000001)
    }

    @Test
    fun testDivision() {
        assertEquals(3.3333333, calc.division(10.0, 3.0), 0.000001)
    }

    @Test
    fun testDivisionByZero() {
        try {
            calc.division(1.0, 0.0)
            fail("Ожидалост исключение ArithmeticException")
        } catch (e: ArithmeticException){
            assertEquals("Division by zero", e.message)
        }
    }

}