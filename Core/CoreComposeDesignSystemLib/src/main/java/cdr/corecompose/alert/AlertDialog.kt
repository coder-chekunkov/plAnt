package cdr.corecompose.alert

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.dual.vertical.DualBlueberryVertical
import cdr.corecompose.text.Body1Secondary
import cdr.corecompose.text.Title2
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor

/**
 * Алерт-диалог
 *
 * @param data объект, который описывает содержимое алерт диалога
 * @param onDismissClick действие, которое происходит при закрытии алерт-диалога
 * @param onFirstButtonClick действие, которое происходит при нажатии на первую кнопку
 * @param onSecondButtonClick действие, которое происходит при нажатии на вторую кнопку
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun AlertDialog(
    data: AlertDialogData,
    onDismissClick: (() -> Unit),
    onFirstButtonClick: (() -> Unit),
    onSecondButtonClick: (() -> Unit)? = null
) {
    Dialog(
        onDismissRequest = onDismissClick,
        properties = data.properties
    ) {
        Surface(
            modifier = Modifier.padding(4.dp),
            color = PlAntTokens.Background1.getThemedColor(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 25.dp
                        ),
                        painter = painterResource(id = data.image),
                        contentDescription = null,
                    )
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(48.dp),
                        onClick = onDismissClick
                    ) {
                        Icon(
                            painter = painterResource(id = cdr.coreresourceslib.R.drawable.ic_close),
                            contentDescription = stringResource(id = cdr.coreresourceslib.R.string.close),
                            tint = PlAntTokens.IconSecondary.getThemedColor()
                        )
                    }
                }

                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Title2(
                        text = data.title,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        maxLines = 2
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Body1Secondary(
                        text = data.subtitle,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        maxLines = 4
                    )
                }

                if (onSecondButtonClick == null) {
                    Blueberry(
                        text = data.firstButtonText,
                        style = data.firstButtonStyle,
                        onClick = onFirstButtonClick
                    )
                } else {
                    DualBlueberryVertical(
                        firstButtonText = data.firstButtonText,
                        secondButtonText = data.secondButtonText ?: "",
                        firstButtonClick = onFirstButtonClick,
                        secondButtonClick = onSecondButtonClick,
                        firstButtonStyle = data.firstButtonStyle,
                        secondButtonStyle = data.secondButtonStyle
                    )
                }
            }
        }
    }
}
