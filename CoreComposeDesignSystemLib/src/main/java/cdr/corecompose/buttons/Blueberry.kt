package cdr.corecompose.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import cdr.corecompose.theming.BlackAlpha
import cdr.corecompose.theming.ElectricBlue0
import cdr.corecompose.theming.Gray
import cdr.corecompose.theming.Orange
import cdr.corecompose.theming.Transparent
import cdr.corecompose.theming.White


/**
 * Основная кнопка - "Голубика"
 *
 * @param text текст на кнопке
 * @param style стиль кнопки [BlueberryStyle]
 * @param onClick действие по нажатию
 * @param modifier Modifier
 * @param isEnabled true - enable, false - disable
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Blueberry(
    text: String,
    style: BlueberryStyle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) = when (style) {
    BlueberryStyle.Standard -> StandardBlueberry(text, onClick, modifier, isEnabled)
    BlueberryStyle.Transparent -> TransparentBlueberry(text, onClick, modifier, isEnabled)
    BlueberryStyle.Negative -> NegativeBlueberry(text, onClick, modifier, isEnabled)
}

/**
 * Стандартная кнопка - "Голубика"
 *
 * @param text текст на кнопке
 * @param onClick действие по нажатию
 * @param modifier Modifier
 * @param isEnabled true - enable, false - disable
 *
 * @author Alexandr Chekunkov
 */
@Composable
private fun StandardBlueberry(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = ElectricBlue0,
            disabledContainerColor = Gray
        ),
        textColor = White,
        disabledTextColor = BlackAlpha
    )
}

/**
 * Прозрачная кнопка - "Голубика"
 *
 * @param text текст на кнопке
 * @param onClick действие по нажатию
 * @param modifier Modifier
 * @param isEnabled true - enable, false - disable
 *
 * @author Alexandr Chekunkov
 */
@Composable
private fun TransparentBlueberry(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Transparent,
            disabledContainerColor = Transparent
        ),
        textColor = ElectricBlue0,
        disabledTextColor = ElectricBlue0
    )
}

/**
 * Негативная кнопка - "Голубика"
 *
 * @param text текст на кнопке
 * @param onClick действие по нажатию
 * @param modifier Modifier
 * @param isEnabled true - enable, false - disable
 *
 * @author Alexandr Chekunkov
 */
@Composable
private fun NegativeBlueberry(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange,
            disabledContainerColor = Gray
        ),
        textColor = White,
        disabledTextColor = BlackAlpha
    )
}


@Composable
private fun InnerBlueberry(
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textColor: Color,
    disabledTextColor: Color,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        enabled = isEnabled,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            color = if (isEnabled) textColor else disabledTextColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Стили для кнопки 'Blueberry'
 *
 * @author Alexandr Chekunkov
 */
enum class BlueberryStyle {
    /** Стандарт кнопки */
    Standard,

    /** Прозрачная кнопка с текстом */
    Transparent,

    /** Warning кнопка */
    Negative
}

private val BlueberryModifier = Modifier
    .requiredHeight(48.dp)
    .fillMaxWidth()