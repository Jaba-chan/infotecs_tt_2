package ru.evgenykuzakov.infotecs_tt_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.evgenykuzakov.infotecs_tt_2.theme.AppTheme
import java.math.BigDecimal

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: MainActivityViewModel by viewModels()

        setContent {
            AppTheme {
                Scaffold(Modifier.fillMaxSize()) { innerPadding ->

                    val state by viewModel.uiState.collectAsState()
                    val operators = listOf(
                        Operator.Plus,
                        Operator.Minus,
                        Operator.Multiply,
                        Operator.Division,
                    )

                    Column(Modifier.padding(innerPadding)) {

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 100.dp, horizontal = 32.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            NumberField(
                                value = state.firstNum,
                                onValueChange = viewModel::handleFirstNumberInput
                            )

                            NumberField(
                                value = state.secondNum,
                                onValueChange = viewModel::handleSecondNumberInput
                            )
                        }

                        Row(
                            Modifier.align(Alignment.CenterHorizontally),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            operators.forEach { operator ->
                                OperatorButton(viewModel::calc, operator)
                            }
                        }

                        Spacer(Modifier.height(32.dp))

                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = state.error ?: state.result,
                            color = if (state.error != null) Color.Red else Color.Black
                        )

                    }
                }
            }
        }
    }

    companion object {
        init {
            System.loadLibrary("infotecs_tt_2")
        }
    }

}
