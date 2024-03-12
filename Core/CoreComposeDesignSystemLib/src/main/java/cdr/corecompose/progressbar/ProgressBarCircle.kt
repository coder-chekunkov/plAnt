package cdr.corecompose.progressbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cdr.corecompose.text.Body1
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor

/**
 * Бесконечный круглый прогресс бар
 *
 * @param modifier модифаер
 * @param text текст, который используется под прогресс баром
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun ProgressBarCircle(
    modifier: Modifier = Modifier,
    text: String? = null
) {
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = modifier.then(Modifier.size(48.dp)),
            color = PlAntTokens.Brand.getThemedColor()
        )

        if (text != null) {
            Body1(
                modifier = Modifier.padding(top = 32.dp),
                text = text,
                maxLines = 2,
                textAlign = TextAlign.Center
            )
        }
    }
}