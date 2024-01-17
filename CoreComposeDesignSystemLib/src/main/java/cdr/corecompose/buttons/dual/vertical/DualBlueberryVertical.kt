package cdr.corecompose.buttons.dual.vertical

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle

/**
 * Две вертикальные кнопки Blueberry без отсупов между друг другом
 *
 * @param modifier модифаер
 * @param firstButtonText текст первой кнопки
 * @param secondButtonText текст второй кнопки
 * @param firstButtonClick действие по нажатию первой кнопки
 * @param secondButtonClick действие по нажатию второй кнопки
 * @param secondButtonStyle стиль второй кнопки (дефолт - прозрачный)
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun DualBlueberryVertical(
    modifier: Modifier = Modifier,
    firstButtonText: String,
    secondButtonText: String,
    firstButtonClick: () -> Unit,
    secondButtonClick: () -> Unit,
    secondButtonStyle: BlueberryStyle = BlueberryStyle.Transparent
) {
    Column(
        modifier = modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Blueberry(
            text = firstButtonText,
            style = BlueberryStyle.Standard,
            onClick = firstButtonClick,
            verticalPadding = 0.dp
        )

        Blueberry(
            text = secondButtonText,
            style = secondButtonStyle,
            onClick = secondButtonClick,
            verticalPadding = 0.dp
        )
    }
}