package cdr.corecompose.snackbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor
import cdr.coreresourceslib.R

/**
 * Вспывающие окно с сообщением
 *
 * @param snackbarData данные о вспывающем окне при запуске
 * @param data данные для запуска вспывающего окна с сообщением
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun SnackbarCard(
    snackbarData: SnackbarData,
    data: SnackbarCardData,
) {
    val containerColor = PlAntTokens.SnackbarCardContainerPrimary.getThemedColor()
    val contentColor = PlAntTokens.SnackbarCardContentPrimary.getThemedColor()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))
                .background(containerColor)
                .padding(
                    vertical = 16.dp,
                    horizontal = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (data.icon != null) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = data.icon),
                    contentDescription = null,
                    tint = data.iconTint
                )
            }

            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f),
                text = snackbarData.visuals.message,
                textAlign = TextAlign.Start,
                maxLines = 2,
                style = TextStyle(
                    color = contentColor,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.em
                ),
                overflow = TextOverflow.Ellipsis
            )

            if (data.closeIcon) {
                IconButton(
                    modifier = Modifier.size(28.dp),
                    onClick = { snackbarData.dismiss() }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = stringResource(id = R.string.close),
                        tint = contentColor
                    )
                }
            }
        }
    }
}

/**
 * Функция расширения для [SnackbarHostState], которая позволяет запускать [SnackbarCard].
 * Данная функция используется для проверки наличия уже запущенного окна с сообщением.
 * Если на экране уже отображается [SnackbarCard], то новое не будет добавленно в стэк отображения.
 *
 * @author Alexandr Chekunkov
 */
suspend fun SnackbarHostState.showSnackbarCard(message: String) {
    if (this.currentSnackbarData == null) {
        this.showSnackbar(
            message = message,
            duration = SnackbarDuration.Short
        )
    }
}

/**
 * Данные для запуска вспывающего окна с сообщением
 *
 * @property icon иконка вспывающего окна с сообщением
 * @property iconTint цвет иконки вспывающего окна с сообщением
 * @property closeIcon наличие кнопки-крестика закрытия вспывающего окна с сообщением
 *
 * @author Alexandr Chekunkov
 */
data class SnackbarCardData(
    @DrawableRes val icon: Int? = null,
    val iconTint: Color = Color.White,
    val closeIcon: Boolean = false,
)