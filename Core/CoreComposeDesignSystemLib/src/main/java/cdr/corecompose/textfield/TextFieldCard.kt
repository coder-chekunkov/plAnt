package cdr.corecompose.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor

/**
 * Поле ввода текста
 *
 * @param modifier модифаер для настройки поля ввода текст
 * @param style стиль поля ввода текста
 * @param text текст
 * @param onTextChange лямбда изменения текста
 * @param label лебл
 * @param maxLines максимальное количество символов в поле ввода текста
 * @param subtitleVisibility виден ли подзаголовок
 * @param subtitleText подзаголвок
 * @param keyboardOptions настройка клавиатуры
 *
 * TODO: добавить возможность показа текста, если поле ввода имеет тип "password"
 * TODO: разобраться с проблемой сокрытия клавиатуры при изменении стиля
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun TextFieldCard(
    modifier: Modifier = Modifier,
    style: TextFieldCardStyles,
    text: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
    label: String,
    maxLines: Int = 1,
    subtitleVisibility: Boolean = false,
    subtitleText: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    when (style) {
        TextFieldCardStyles.Standard -> StandardTextFieldCard(
            modifier = modifier,
            text = text,
            onTextChange = onTextChange,
            label = label,
            maxLines = maxLines,
            subtitleVisibility = subtitleVisibility,
            subtitleText = subtitleText,
            keyboardOptions = keyboardOptions
        )

        TextFieldCardStyles.Warning -> WarningTextFieldCard(
            modifier = modifier,
            text = text,
            onTextChange = onTextChange,
            label = label,
            maxLines = maxLines,
            subtitleVisibility = subtitleVisibility,
            subtitleText = subtitleText,
            keyboardOptions = keyboardOptions
        )
    }
}

/**
 * Стандартное поле ввода текста, которое может быть кастомизированное
 *
 * @param modifier модифаер для настройки поля ввода текст
 * @param text текст
 * @param onTextChange лямбда изменения текста
 * @param label лебл
 * @param maxLines максимальное количество символов в поле ввода текста
 * @param subtitleVisibility виден ли подзаголовок
 * @param subtitleText подзаголвок
 * @param keyboardOptions настройка клавиатуры
 *
 * @author Alexandr Chekunkov
 */
@Composable
internal fun StandardTextFieldCard(
    modifier: Modifier = Modifier,
    text: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
    label: String,
    maxLines: Int = 1,
    subtitleVisibility: Boolean,
    subtitleText: String,
    keyboardOptions: KeyboardOptions
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        TextField(
            modifier = modifier.then(
                Modifier.fillMaxWidth()
            ),
            value = text,
            onValueChange = onTextChange,
            maxLines = maxLines,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PlAntTokens.TextPrimary.getThemedColor(),
                unfocusedTextColor = PlAntTokens.TextFieldUnfocusedText.getThemedColor(),
                disabledTextColor = PlAntTokens.TextFieldUnfocusedText.getThemedColor(),
                errorTextColor = PlAntTokens.TextWarning.getThemedColor(),
                focusedLabelColor = PlAntTokens.Brand.getThemedColor(),
                unfocusedLabelColor = PlAntTokens.TextFieldUnfocusedLabel.getThemedColor(),
                focusedContainerColor = PlAntTokens.TextFieldBackground.getThemedColor(),
                unfocusedContainerColor = PlAntTokens.TextFieldBackground.getThemedColor(),
                disabledContainerColor = PlAntTokens.TextFieldBackground.getThemedColor(),
                cursorColor = PlAntTokens.Brand.getThemedColor(),
                focusedIndicatorColor = PlAntTokens.Transparent.getThemedColor(),
                unfocusedIndicatorColor = PlAntTokens.Transparent.getThemedColor()
            ),
            label = {
                Text(
                    text = label,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.em
                    ),
                    overflow = TextOverflow.Ellipsis
                )
            },
            visualTransformation = if (keyboardOptions.keyboardType == KeyboardType.Password)
                PasswordVisualTransformation() else VisualTransformation.None
        )

        if (subtitleVisibility) {
            Text(
                text = subtitleText,
                modifier = Modifier.padding(
                    top = 6.dp,
                    start = 14.dp,
                    end = 14.dp
                ),
                maxLines = 1,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.em
                ),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Warning поле ввода текста, которое может быть кастомизированное
 *
 * @param modifier модифаер для настройки поля ввода текст
 * @param text текст
 * @param onTextChange лямбда изменения текста
 * @param label лебл
 * @param maxLines максимальное количество символов в поле ввода текста
 * @param subtitleVisibility виден ли подзаголовок
 * @param subtitleText подзаголвок
 * @param keyboardOptions настройка клавиатуры
 *
 * @author Alexandr Chekunkov
 */
@Composable
internal fun WarningTextFieldCard(
    modifier: Modifier = Modifier,
    text: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
    label: String,
    maxLines: Int = 1,
    subtitleVisibility: Boolean,
    subtitleText: String,
    keyboardOptions: KeyboardOptions
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        TextField(
            modifier = modifier.then(
                Modifier.fillMaxWidth()
            ),
            value = text,
            onValueChange = onTextChange,
            maxLines = maxLines,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = PlAntTokens.TextFieldWarningText.getThemedColor(),
                unfocusedTextColor = PlAntTokens.TextFieldWarningUnfocusedText.getThemedColor(),
                disabledTextColor = PlAntTokens.TextFieldWarningUnfocusedText.getThemedColor(),
                errorTextColor = PlAntTokens.TextWarning.getThemedColor(),
                focusedLabelColor = PlAntTokens.Warning.getThemedColor(),
                unfocusedLabelColor = PlAntTokens.TextFieldWarningUnfocusedLabel.getThemedColor(),
                focusedContainerColor = PlAntTokens.TextFieldWarningBackground.getThemedColor(),
                unfocusedContainerColor = PlAntTokens.TextFieldWarningBackground.getThemedColor(),
                disabledContainerColor = PlAntTokens.TextFieldWarningBackground.getThemedColor(),
                cursorColor = PlAntTokens.Warning.getThemedColor(),
                focusedIndicatorColor = PlAntTokens.Transparent.getThemedColor(),
                unfocusedIndicatorColor = PlAntTokens.Transparent.getThemedColor()
            ),
            label = {
                Text(
                    text = label,
                    maxLines = 1,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.em
                    ),
                    overflow = TextOverflow.Ellipsis
                )
            },
            visualTransformation = if (keyboardOptions.keyboardType == KeyboardType.Password)
                PasswordVisualTransformation() else VisualTransformation.None
        )

        if (subtitleVisibility) {
            Text(
                text = subtitleText,
                modifier = Modifier.padding(
                    top = 6.dp,
                    start = 14.dp,
                    end = 14.dp
                ),
                maxLines = 1,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.em
                ),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Стили для поля ввода текста
 *
 * @author Alexandr Chekunkov
 */
enum class TextFieldCardStyles {

    /** Стандартный стиль */
    Standard,

    /** Стиль ошибка */
    Warning
}