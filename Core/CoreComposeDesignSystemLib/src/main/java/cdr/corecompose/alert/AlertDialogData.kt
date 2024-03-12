package cdr.corecompose.alert

import androidx.annotation.DrawableRes
import androidx.compose.ui.window.DialogProperties
import cdr.corecompose.buttons.blueberry.BlueberryStyle

/**
 * Объект, который описывает содержимое алерт диалога
 *
 * @property title заголовок
 * @property subtitle подзаголовок
 * @property image картинка (является ссылкой на ресурс)
 * @property firstButtonText текст первой кнопки
 * @property secondButtonText текст второй кнопки
 * @property firstButtonStyle стиль первой кнопки
 * @property secondButtonStyle стиль второй кнопки
 * @property properties свойства алерт диалога
 *
 * @author Alexandr Chekunkov
 */
data class AlertDialogData(
    val title: String,
    val subtitle: String,
    @DrawableRes val image: Int,
    val firstButtonText: String,
    val secondButtonText: String? = null,
    val firstButtonStyle: BlueberryStyle = BlueberryStyle.Standard,
    val secondButtonStyle: BlueberryStyle = BlueberryStyle.Transparent,
    val properties: DialogProperties = DialogProperties()
)
