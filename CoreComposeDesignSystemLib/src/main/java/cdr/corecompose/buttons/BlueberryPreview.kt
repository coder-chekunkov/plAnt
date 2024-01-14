package cdr.corecompose.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.White

/**
 * Превью для всех доступных кнопок
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
fun BlueberryPreview() {
    Column(
        modifier = Modifier
            .background(White)
            .size(width = 500.dp, height = 300.dp)
    ) {
        Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {})
        Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {}, isEnabled = false)
        Blueberry(text = "Подтвердить", style = BlueberryStyle.Negative, onClick = {})
        Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {})
    }
}