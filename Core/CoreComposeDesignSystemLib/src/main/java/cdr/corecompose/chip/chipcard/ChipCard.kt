package cdr.corecompose.chip.chipcard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor

/**
 * Карточка-чипса, которая используется для выбора каких-то данных
 *
 * @param title заголовок карточки-чипсы
 * @param isSelected выбрана ли карточка-чипса
 * @param style стиль карточки-чипсы
 * @param onSelectChanged изменение выбора карточки-чипсы
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun ChipCard(
    title: String,
    isSelected: Boolean,
    style: ChipCardStyle = ChipCardStyle.Standard,
    onSelectChanged: ((Boolean) -> Unit)? = null
) {
    var selected by remember(isSelected) { mutableStateOf(isSelected) }
    var chipStyle by remember(style) { mutableStateOf(style) }

    val backgroundColor = when {
        chipStyle == ChipCardStyle.Warning -> PlAntTokens.ChipWarningBackground.getThemedColor()
        selected -> PlAntTokens.ChipSelectableBackground.getThemedColor()
        else -> PlAntTokens.ChipNotSelectableBackground.getThemedColor()
    }

    val textColor = when {
        chipStyle == ChipCardStyle.Warning -> PlAntTokens.ChipWarningText.getThemedColor()
        selected -> PlAntTokens.ChipSelectableText.getThemedColor()
        else -> PlAntTokens.ChipNotSelectableText.getThemedColor()
    }

    Box(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable {
                chipStyle = ChipCardStyle.Standard
                selected = !selected
                onSelectChanged?.invoke(selected)
            }
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp
                ),
            text = title,
            maxLines = 1,
            style = TextStyle(
                color = textColor,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.em
            ),
        )
    }
}

/**
 * Стиль для карточки-чипсы
 *
 * @author Alexandr Chekunkov
 */
enum class ChipCardStyle {
    /** Стандартный */
    Standard,

    /** Предупреждающий */
    Warning
}