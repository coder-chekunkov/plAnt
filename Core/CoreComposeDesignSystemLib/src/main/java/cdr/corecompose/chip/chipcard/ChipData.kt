package cdr.corecompose.chip.chipcard

/**
 * Объект, который описывает содержимое карточки-чипсы
 *
 * @property id уникальный номер карточки-чипсы
 * @property title текст на карточке-чипсы
 * @property style стиль карточки-чипсы
 * @property isSelected выбрана карточка-чипса
 *
 * @author Alexandr Chekunkov
 */
data class ChipData(
    val id: Int,
    val title: String,
    val style: ChipCardStyle = ChipCardStyle.Standard,
    val isSelected: Boolean = false
)
