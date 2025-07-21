package ru.evgenykuzakov.infotecs_tt_2

data class MainActivityUIState(
    val error: String? = null,
    val firstNum: String = "",
    val secondNum: String = "",
    val operator: Operator = Operator.Plus,
    val result: String = ""
)

sealed class Operator(val symbol: String){
    data object Plus: Operator("+")
    data object Minus: Operator("-")
    data object Multiply: Operator("×")
    data object Division: Operator("÷")
}