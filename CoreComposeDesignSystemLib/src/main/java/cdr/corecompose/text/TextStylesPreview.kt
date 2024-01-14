package cdr.corecompose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.White

/**
 * Превью для всех доступных текстов
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
fun TextStylesPreview() {
    Column(
        modifier = Modifier
            .background(White)
            .size(width = 300.dp, height = 200.dp)
    ) {
        Headline1(text = "Headline1")
        Headline2(text = "Headline2")
        Headline3(text = "Headline3")
        Title1(text = "Title1")
        Title2(text = "Title2")
        Body1(text = "Body1")
        Body2(text = "Body2")
    }
}
