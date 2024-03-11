### Модуль Дизайн Системы

Данный модуль отвечает за дизайн систему в приложении. Весь функционал реализован на [Jetpack Compose](https://developer.android.com/jetpack/compose). Все модули, которые взаимодействуют с пользователем, должны использовать UI-элементы данного модуля.

> Дизайн система — набор компонентов, правил, предписаний и инструментов для разработки качественного интерфейса приложения.

В дизайн системе реализовано большое количество UI-элементов, которые необходимы для качественной и единой разработки, а именно:

- Theme (Preview + Main)
- TextStyles
- Buttons
    - Blueberry
    - DualBlueberryHorizontal
    - DualBlueberryVertical
- Progress
    - ProgressCircle

---

**Theme (Preview + Main)** <br/>
Любое современное приложение должно быть оптимизировано для раз устройств и тем (темная и светлая). Данный модуль несет ответственность за темизацию всего приложения. 
Существует набор токенов, переопределяя которые, меняется цвет элемента.

Также появилась необходимость реализовать preview-тему, которая бы использовалась для предпоказа элемента (используется только для разработки).

**TextStyles** <br/>
Для отображения пользователю какой-либо информации - используются текстовые поля. Модуль дизайн системы поддерживает разные типы текста, которые могут сообщать критическую информацию, быть заголовками и т.д. Названия и внешний вид каждого из текста изображен на рисунке ниже в двух темах (светлая и темная). 

<img src="https://github.com/coder-chekunkov/plAnt/blob/develop/CoreComposeDesignSystemLib/examples/text_styles_preview.png" alt="TextStyles" width="500"/>

**Blueberry** <br/>
Blueberry - это нестандартное название кнопок, которые помогают взаимодействовать с пользователем. Имеется четыре доступных темы: стандарт, предупреждение, текст-кнопка и отключенное состояние. Все типы изображены на рисунке ниже в двух темах (светлая и темная).

<img src="https://github.com/coder-chekunkov/plAnt/blob/develop/CoreComposeDesignSystemLib/examples/blueberry_preview.png" alt="Blueberry" width="500"/>

**DualBlueberryHorizontal** <br/>
DualBlueberryHorizontal - это набор двух кнопок Blueberry, которые расположены горизонтально. Для каждой кнопки можно настроить свой стиль и поведение. Примеры изображены на рисунке ниже в двух темах (светлая и темная).

<img src="https://github.com/coder-chekunkov/plAnt/blob/develop/CoreComposeDesignSystemLib/examples/dual_blueberry_horizontal_preview.png" alt="DualBlueberryHorizontal" width="500"/>

**DualBlueberryVertical** <br/>
DualBlueberryHorizontal - это набор двух кнопок Blueberry, которые расположены вертикально. Для каждой кнопки можно настроить свой стиль и поведение. Примеры изображены на рисунке ниже в двух темах (светлая и темная).

<img src="https://github.com/coder-chekunkov/plAnt/blob/develop/CoreComposeDesignSystemLib/examples/dual_blueberry_vertical_preview.png" alt="DualBlueberryVertical" width="500"/>

**ProgressCircle** <br/>
ProgressCircle - это доработанный ProgressBar, который вращается бесконечно. Следует использовать для загрузки каких-либо элементов или отображение статического состояния. Есть возможность добавить текст пояснения. Пример изображен на gif ниже только в темной теме.

<img src="https://github.com/coder-chekunkov/plAnt/blob/develop/CoreComposeDesignSystemLib/examples/progress_bar_circle_preview.gif" alt="ProgressCircle" width="250"/>
