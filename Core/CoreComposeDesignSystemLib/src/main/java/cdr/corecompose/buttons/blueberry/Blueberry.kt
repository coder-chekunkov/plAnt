package cdr.corecompose.buttons.blueberry

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
import androidx.compose.ui.unit.Dp
import cdr.corecompose.theming.getThemedColor
import cdr.corecompose.theming.PlAntTokens


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
 * Основная кнопка - "Голубика"
 *
 * @param text текст на кнопке
 * @param style стиль кнопки [BlueberryStyle]
 * @param onClick действие по нажатию
 * @param modifier Modifier
 * @param isEnabled true - enable, false - disable
 * @param horizontalPadding горизонтальные отступы
 * @param verticalPadding вертикальные отступы
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
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 16.dp
) = when (style) {
    BlueberryStyle.Standard -> StandardBlueberry(text, onClick, modifier, isEnabled, horizontalPadding, verticalPadding)
    BlueberryStyle.Transparent -> TransparentBlueberry(text, onClick, modifier, isEnabled, horizontalPadding, verticalPadding)
    BlueberryStyle.Negative -> NegativeBlueberry(text, onClick, modifier, isEnabled, horizontalPadding, verticalPadding)
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
    isEnabled: Boolean = true,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 16.dp
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PlAntTokens.ButtonBrand.getThemedColor(),
            disabledContainerColor = PlAntTokens.ButtonDisabled.getThemedColor()
        ),
        textColor = PlAntTokens.TextButtonWhite.getThemedColor(),
        disabledTextColor = PlAntTokens.TextButtonDisabled.getThemedColor()
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
    isEnabled: Boolean = true,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 16.dp
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PlAntTokens.Transparent.getThemedColor(),
            disabledContainerColor = PlAntTokens.Transparent.getThemedColor()
        ),
        textColor = PlAntTokens.TextBrand.getThemedColor(),
        disabledTextColor = PlAntTokens.TextButtonDisabled.getThemedColor()
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
    isEnabled: Boolean = true,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 16.dp
) {
    InnerBlueberry(
        text = text,
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            .then(BlueberryModifier),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PlAntTokens.ButtonWarning.getThemedColor(),
            disabledContainerColor = PlAntTokens.ButtonDisabled.getThemedColor()
        ),
        textColor = PlAntTokens.TextButtonWhite.getThemedColor(),
        disabledTextColor = PlAntTokens.TextButtonDisabled.getThemedColor()
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