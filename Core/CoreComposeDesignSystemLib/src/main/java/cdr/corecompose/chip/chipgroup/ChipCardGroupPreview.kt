package cdr.corecompose.chip.chipgroup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.appbar.AppBar
import cdr.corecompose.chip.chipcard.ChipData
import cdr.corecompose.text.Body2
import cdr.corecompose.text.Body3
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для [ChipCardGroup] (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun ChipCardGroupLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background0.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background0.getThemedColor(),
                    title = "ChipCardGroup"
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Background0.getThemedColor())
            ) {
                val chipList = listOf(
                    ChipData(id = 0, title = "Разработчик"),
                    ChipData(id = 1, title = "Тестировщик"),
                    ChipData(id = 2, title = "Менеджер")
                )

                Body2(text = "Одиночный выбор")
                ChipCardGroup(
                    modifier = Modifier.padding(vertical = 8.dp),
                    chips = chipList,
                    isSingleSelect = true,
                    onSelectedChips = { _ -> }
                )
                Body3(text = "Выбранные чипсы:")
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

                Body2(modifier = Modifier.padding(vertical = 8.dp), text = "Множественный выбор")
                ChipCardGroup(
                    modifier = Modifier.padding(vertical = 8.dp),
                    chips = chipList,
                    isSingleSelect = false,
                    onSelectedChips = { _ -> }
                )
                Body3(text = "Выбранные чипсы: ")
            }
        }
    }
}

/**
 * Превью для [ChipCardGroup] (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun ChipCardGroupDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background0.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background0.getThemedColor(),
                    title = "ChipCardGroup"
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Background0.getThemedColor())
            ) {
                val chipList = listOf(
                    ChipData(id = 0, title = "Разработчик"),
                    ChipData(id = 1, title = "Тестировщик"),
                    ChipData(id = 2, title = "Менеджер")
                )

                Body2(text = "Одиночный выбор")
                ChipCardGroup(
                    modifier = Modifier.padding(vertical = 8.dp),
                    chips = chipList,
                    isSingleSelect = true,
                    onSelectedChips = { _ -> }
                )
                Body3(text = "Выбранные чипсы:")
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

                Body2(modifier = Modifier.padding(vertical = 8.dp), text = "Множественный выбор")
                ChipCardGroup(
                    modifier = Modifier.padding(vertical = 8.dp),
                    chips = chipList,
                    isSingleSelect = false,
                    onSelectedChips = { _ -> }
                )
                Body3(text = "Выбранные чипсы: ")
            }
        }
    }
}