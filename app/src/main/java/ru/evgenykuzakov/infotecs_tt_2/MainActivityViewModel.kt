package ru.evgenykuzakov.infotecs_tt_2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class MainActivityViewModel : ViewModel() {
    private val calculator = NativeCalc()

    private val _uiState = MutableStateFlow(MainActivityUIState())
    val uiState: StateFlow<MainActivityUIState> = _uiState

    fun handleFirstNumberInput(text: String) {
        _uiState.update { it.copy(firstNum = text) }
    }

    fun handleSecondNumberInput(text: String) {
        _uiState.update { it.copy(secondNum = text) }
    }

    fun calc(operator: Operator) {
        val firstNum = _uiState.value.firstNum.toDoubleOrNull()
        val secondNum = _uiState.value.secondNum.toDoubleOrNull()

        if (firstNum == null || secondNum == null) return
        _uiState.update { it.copy(operator = operator) }
        _uiState.update {
            it.copy(
                result = when (_uiState.value.operator) {
                    Operator.Division -> calculator.division(firstNum, secondNum)
                    Operator.Minus -> calculator.minus(firstNum, secondNum)
                    Operator.Multiply -> calculator.multiply(firstNum, secondNum)
                    Operator.Plus -> calculator.plus(firstNum, secondNum)
                }.formatNum()
            )
        }

    }

    private fun Double?.formatNum(): String {
        return if (this != null)
            BigDecimal(this.toString())
                .stripTrailingZeros()
                .toPlainString()
        else ""
    }
}