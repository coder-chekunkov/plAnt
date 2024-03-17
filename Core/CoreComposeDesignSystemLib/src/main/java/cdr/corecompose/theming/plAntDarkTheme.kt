package cdr.corecompose.theming

import androidx.compose.ui.graphics.Color

/**
 * Значения цветов для темной темы
 *
 * @author Alexandr Chekunkov
 */
internal fun darkTheme(): Map<PlAntTokens, Color> = mapOf(
    PlAntTokens.Background0 to Graphite2,
    PlAntTokens.Background1 to Graphite1,
    PlAntTokens.ButtonBrand to ElectricBlue,
    PlAntTokens.ButtonDisabled to Gray,
    PlAntTokens.ButtonWarning to Orange,
    PlAntTokens.ButtonTransparent to Transparent,
    PlAntTokens.Brand to ElectricBlue,
    PlAntTokens.IconSecondary to White1,
    PlAntTokens.TextPrimary to White,
    PlAntTokens.TextSecondary to White1,
    PlAntTokens.TextButtonDisabled to Graphite0,
    PlAntTokens.TextButtonWhite to White,
    PlAntTokens.TextBrand to ElectricBlue,
    PlAntTokens.TextWarning to Orange,
    PlAntTokens.Transparent to Transparent,
    PlAntTokens.TextFieldBackground to Graphite0,
    PlAntTokens.TextFieldText to Gray2,
    PlAntTokens.TextFieldUnfocusedText to Gray2,
    PlAntTokens.TextFieldUnfocusedLabel to Gray2,
    PlAntTokens.TextFieldWarningBackground to Orange2,
    PlAntTokens.TextFieldWarningText to Orange,
    PlAntTokens.TextFieldWarningUnfocusedText to Orange,
    PlAntTokens.TextFieldWarningUnfocusedLabel to Orange,
    PlAntTokens.Primary to White,
    PlAntTokens.SnackbarCardContainerPrimary to White,
    PlAntTokens.SnackbarCardContentPrimary to Black,
    PlAntTokens.Secondary to White1,
    PlAntTokens.Warning to Orange
)
