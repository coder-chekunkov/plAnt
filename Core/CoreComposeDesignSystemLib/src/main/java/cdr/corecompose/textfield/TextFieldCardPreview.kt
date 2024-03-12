package cdr.corecompose.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для поля ввода (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun TextFieldCardPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        var text1 by remember { mutableStateOf(TextFieldValue()) }
        var text2 by remember { mutableStateOf(TextFieldValue("123456")) }
        var text3 by remember { mutableStateOf(TextFieldValue()) }
        var subtitle1 by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(PlAntTokens.Background1.getThemedColor())
        ) {
            TextFieldCard(
                style = TextFieldCardStyles.Standard,
                label = "Введите комментарий",
                text = text1,
                onTextChange = { newText ->
                    subtitle1 = if (newText.text.length < 100) {
                        text1 = newText
                        false
                    } else {
                        true
                    }
                },
                maxLines = 3,
                subtitleVisibility = subtitle1,
                subtitleText = "Вы ввели максимальное количество символов"
            )

            TextFieldCard(
                style = TextFieldCardStyles.Standard,
                label = "Введите пароль",
                text = text2,
                onTextChange = { newText -> text2 = newText },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            TextFieldCard(
                style = TextFieldCardStyles.Warning,
                label = "Введите логин",
                text = text3,
                onTextChange = { newText -> text3 = newText }
            )
        }
    }
}

/**
 * Превью для поля ввода (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun TextFieldCardPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        var text1 by remember { mutableStateOf(TextFieldValue("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. ")) }
        var text2 by remember { mutableStateOf(TextFieldValue("123456789")) }
        var text3 by remember { mutableStateOf(TextFieldValue("Сообщение с ошибкой")) }
        var subtitle1 by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(PlAntTokens.Background1.getThemedColor())
        ) {
            TextFieldCard(
                style = TextFieldCardStyles.Standard,
                label = "Введите комментарий",
                text = text1,
                onTextChange = { newText ->
                    subtitle1 = if (newText.text.length < 100) {
                        text1 = newText
                        false
                    } else {
                        true
                    }
                },
                maxLines = 3,
                subtitleVisibility = subtitle1,
                subtitleText = "Вы ввели максимальное количество символов"
            )

            TextFieldCard(
                style = TextFieldCardStyles.Standard,
                label = "Введите пароль",
                text = text2,
                onTextChange = { newText -> text2 = newText },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            TextFieldCard(
                style = TextFieldCardStyles.Warning,
                label = "Введите логин",
                text = text3,
                onTextChange = { newText -> text3 = newText }
            )
        }
    }
}