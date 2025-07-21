package ru.evgenykuzakov.infotecs_tt_2

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
internal fun OperatorButton(
    onClick: (Operator) -> Unit,
    operator: Operator
){
    Button(
        onClick = { onClick(operator) }
    ) {
        Text(text = operator.symbol)
    }
}

@Composable
internal fun RowScope.NumberField(
    value: String,
    onValueChange: (String) -> Unit
){
    TextField(
        modifier = Modifier.weight(1f),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}