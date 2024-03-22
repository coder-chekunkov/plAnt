package cdr.corecompose.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.buttons.blueberry.BlueberryStyle
import cdr.corecompose.buttons.dual.vertical.DualBlueberryVertical
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для [AlertDialog] (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun AlertDialogPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        var alert1 by remember { mutableStateOf(false) }
        var alert2 by remember { mutableStateOf(false) }
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(PlAntTokens.Background1.getThemedColor()),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PlAntTokens.Background1.getThemedColor())
            ) {
                DualBlueberryVertical(
                    firstButtonText = "Алерт-диалог (одна кнопка)",
                    secondButtonText = "Алерт-диалог (две кнопки)",
                    secondButtonStyle = BlueberryStyle.Negative,
                    firstButtonClick = { alert1 = true },
                    secondButtonClick = { alert2 = true }
                )

                if (alert1) {
                    AlertDialog(
                        data = alertDialogData1,
                        onDismissClick = { alert1 = false },
                        onFirstButtonClick = { alert1 = false }
                    )
                }

                if (alert2) {
                    AlertDialog(
                        data = alertDialogData2,
                        onDismissClick = { alert2 = false },
                        onFirstButtonClick = { alert2 = false },
                        onSecondButtonClick = { alert2 = false }
                    )
                }
            }
        }
    }
}

/**
 * Превью для [AlertDialog] (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun AlertDialogPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        var alert1 by remember { mutableStateOf(false) }
        var alert2 by remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(PlAntTokens.Background1.getThemedColor()),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PlAntTokens.Background1.getThemedColor())
            ) {
                DualBlueberryVertical(
                    firstButtonText = "Алерт-диалог (одна кнопка)",
                    secondButtonText = "Алерт-диалог (две кнопки)",
                    secondButtonStyle = BlueberryStyle.Negative,
                    firstButtonClick = { alert1 = true },
                    secondButtonClick = { alert2 = true }
                )

                if (alert1) {
                    AlertDialog(
                        data = alertDialogData1,
                        onDismissClick = { alert1 = false },
                        onFirstButtonClick = { alert1 = false }
                    )
                }

                if (alert2) {
                    AlertDialog(
                        data = alertDialogData2,
                        onDismissClick = { alert2 = false },
                        onFirstButtonClick = { alert2 = false },
                        onSecondButtonClick = { alert2 = false }
                    )
                }
            }
        }
    }
}

private const val LOREM_TEST_TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,"
private val alertDialogData1 = AlertDialogData(
    title = LOREM_TEST_TEXT,
    subtitle = LOREM_TEST_TEXT,
    image = cdr.coreresourceslib.R.drawable.illustration_256_empty,
    firstButtonText = "Первая кнопка",
)

private val alertDialogData2 = AlertDialogData(
    title = LOREM_TEST_TEXT,
    subtitle = LOREM_TEST_TEXT,
    image = cdr.coreresourceslib.R.drawable.illustration_256_empty,
    firstButtonText = "Первая кнопка",
    secondButtonText = "Вторая кнопка",
    firstButtonStyle = BlueberryStyle.Negative,
    secondButtonStyle = BlueberryStyle.Transparent
)