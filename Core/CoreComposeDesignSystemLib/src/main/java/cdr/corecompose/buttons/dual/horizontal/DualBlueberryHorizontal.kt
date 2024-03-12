package cdr.corecompose.buttons.dual.horizontal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle

/**
 * Две горизонтальный кнопки Blueberry без отсупов между друг другом
 *
 * @param modifier модифаер
 * @param firstButtonText текст первой кнопки
 * @param secondButtonText текст второй кнопки
 * @param firstButtonClick действие по нажатию первой кнопки
 * @param secondButtonClick действие по нажатию второй кнопки
 * @param firstButtonStyle стиль первой кнопки (дефолт - прозрачный)
 * @param secondButtonStyle стиль второй кнопки (дефолт - стандартный)
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun DualBlueberryHorizontal(
    modifier: Modifier = Modifier,
    firstButtonText: String,
    secondButtonText: String,
    firstButtonClick: () -> Unit,
    secondButtonClick: () -> Unit,
    firstButtonStyle: BlueberryStyle = BlueberryStyle.Negative,
    secondButtonStyle: BlueberryStyle = BlueberryStyle.Standard,
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {
        Blueberry(
            modifier = Modifier.weight(1f),
            text = firstButtonText,
            style = firstButtonStyle,
            onClick = firstButtonClick,
            horizontalPadding = 0.dp
        )
        Spacer(modifier = modifier.width(12.dp))
        Blueberry(
            modifier = Modifier.weight(1f),
            text = secondButtonText,
            style = secondButtonStyle,
            onClick = secondButtonClick,
            horizontalPadding = 0.dp
        )
    }
}