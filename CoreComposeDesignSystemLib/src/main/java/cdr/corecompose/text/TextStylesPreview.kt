package cdr.corecompose.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.getThemedColor
import cdr.corecompose.theming.PlAntTheme
import cdr.corecompose.theming.PlAntTokens

/**
 * Превью для всех доступных текстов (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
fun TextStylesPreviewLightTheme() {
    PlAntTheme(darkTheme = false) {
        Column(modifier = Modifier.background(PlAntTokens.Background0.getThemedColor())) {
            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1(text = "Headline1")
                    Headline2(text = "Headline2")
                    Headline3(text = "Headline3")
                    Title1(text = "Title1")
                    Title2(text = "Title2")
                    Body1(text = "Body1")
                    Body2(text = "Body2")
                    Body3(text = "Body3")
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Brand(text = "Headline1")
                    Headline2Brand(text = "Headline2")
                    Headline3Brand(text = "Headline3")
                    Title1Brand(text = "Title1")
                    Title2Brand(text = "Title2")
                    Body1Brand(text = "Body1")
                    Body2Brand(text = "Body2")
                    Body3Brand(text = "Body3")
                }
            }

            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Secondary(text = "Headline1")
                    Headline2Secondary(text = "Headline2")
                    Headline3Secondary(text = "Headline3")
                    Title1Secondary(text = "Title1")
                    Title2Secondary(text = "Title2")
                    Body1Secondary(text = "Body1")
                    Body2Secondary(text = "Body2")
                    Body3Secondary(text = "Body3")
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Warning(text = "Headline1")
                    Headline2Warning(text = "Headline2")
                    Headline3Warning(text = "Headline3")
                    Title1Warning(text = "Title1")
                    Title2Warning(text = "Title2")
                    Body1Warning(text = "Body1")
                    Body2Warning(text = "Body2")
                    Body3Warning(text = "Body3")
                }
            }
        }
    }
}

/**
 * Превью для всех доступных текстов (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
fun TextStylesPreviewDarkTheme() {
    PlAntTheme(darkTheme = true) {
        Column(modifier = Modifier.background(PlAntTokens.Background0.getThemedColor())) {
            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1(text = "Headline1")
                    Headline2(text = "Headline2")
                    Headline3(text = "Headline3")
                    Title1(text = "Title1")
                    Title2(text = "Title2")
                    Body1(text = "Body1")
                    Body2(text = "Body2")
                    Body3(text = "Body3")
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Brand(text = "Headline1")
                    Headline2Brand(text = "Headline2")
                    Headline3Brand(text = "Headline3")
                    Title1Brand(text = "Title1")
                    Title2Brand(text = "Title2")
                    Body1Brand(text = "Body1")
                    Body2Brand(text = "Body2")
                    Body3Brand(text = "Body3")
                }
            }

            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Secondary(text = "Headline1")
                    Headline2Secondary(text = "Headline2")
                    Headline3Secondary(text = "Headline3")
                    Title1Secondary(text = "Title1")
                    Title2Secondary(text = "Title2")
                    Body1Secondary(text = "Body1")
                    Body2Secondary(text = "Body2")
                    Body3Secondary(text = "Body3")
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Headline1Warning(text = "Headline1")
                    Headline2Warning(text = "Headline2")
                    Headline3Warning(text = "Headline3")
                    Title1Warning(text = "Title1")
                    Title2Warning(text = "Title2")
                    Body1Warning(text = "Body1")
                    Body2Warning(text = "Body2")
                    Body3Warning(text = "Body3")
                }
            }
        }
    }
}