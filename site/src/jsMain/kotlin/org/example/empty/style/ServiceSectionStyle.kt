package org.example.empty.style

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.example.empty.components.ServiceCardId
import org.example.empty.models.Theme
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LighterGray.rgb
            )
            .backgroundColor(color = Colors.White)
            .transition(
                CSSTransition(property = "border", duration = 200.ms),
                CSSTransition(property = "background", duration = 200.ms),
            )
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .backgroundColor(color = Theme.Primary.rgb)
    }

    cssRule(" > #${ServiceCardId.ICON}") {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }

    cssRule(":hover > #${ServiceCardId.ICON}") {
        Modifier.backgroundColor(Colors.White)
    }

    cssRule(" > p") {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}