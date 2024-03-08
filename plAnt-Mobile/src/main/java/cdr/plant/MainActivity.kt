package cdr.plant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle
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
    val viewModel = MainViewModel()
    val data by viewModel.data.collectAsStateWithLifecycle()

    PlAntTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background1.getThemedColor())
                .padding(16.dp)
        ) {
            Title2(
                text = "Тестовый экран",
                modifier = Modifier.fillMaxWidth()
            )

            Body1(
                text = "Получение тестовых данных",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )

            Blueberry(
                text = "Получить",
                style = BlueberryStyle.Standard,
                onClick = { viewModel.fetchData() }
            )

            Divider()

            Body1(
                text = data,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )

            if (data.isNotBlank()) {
                Divider()
            }

        }
    }
}