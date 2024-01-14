package cdr.corecompose.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * Headline1
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Headline1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 30.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.em
    ),
    overflow = TextOverflow.Ellipsis
)

/**
 * Headline2
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Headline2(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.em
    ),
    overflow = TextOverflow.Ellipsis
)

/**
 * Headline3
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Headline3(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.em,
        fontWeight = FontWeight.Bold
    ),
    overflow = TextOverflow.Ellipsis
)


/**
 * Title1
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Title1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em
    ),
    overflow = TextOverflow.Ellipsis
)

/**
 * Title2
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Title2(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.em,
        fontWeight = FontWeight.Bold
    ),
    overflow = TextOverflow.Ellipsis
)

/**
 * Body1
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Body1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em
    ),
    overflow = TextOverflow.Ellipsis
)

/**
 * Body2
 *
 * @param text текст
 * @param modifier модифаер
 * @param maxLines максимальное количество строк текста
 * @param textAlign выравнивание текста
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun Body2(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) = Text(
    text = text,
    modifier = modifier,
    maxLines = maxLines,
    textAlign = textAlign,
    style = TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.em,
        fontWeight = FontWeight.Bold
    ),
    overflow = TextOverflow.Ellipsis
)