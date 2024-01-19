package cdr.plant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cdr.corecompose.buttons.dual.horizontal.DualBlueberryHorizontal
import cdr.corecompose.text.Body1
import cdr.corecompose.text.Title2
import cdr.corecompose.theming.PlAntTheme
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor

/**
 * Тестовый экран
 *
 * @author Alexandr Chekunkov
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
private fun MainContent() {
    var counter by remember { mutableStateOf(0) }

    PlAntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background1.getThemedColor())
                .padding(16.dp)
        ) {
            Title2(
                text = "Тестовый экран",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Body1(
                text = "Счётчик: $counter",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )

            DualBlueberryHorizontal(
                firstButtonText = "Минус",
                secondButtonText = "Плюс",
                firstButtonClick = { counter -= 1 },
                secondButtonClick = { counter += 1 })
        }
    }
}