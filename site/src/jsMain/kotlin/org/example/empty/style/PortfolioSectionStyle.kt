package org.example.empty.style

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.example.empty.components.PortfolioCardId.BOX_PARENT
import org.example.empty.components.PortfolioCardId.COLUMN_PARENT
import org.example.empty.components.PortfolioCardId.DESCRIPTION
import org.example.empty.components.PortfolioCardId.GREEN_OVERLAY
import org.example.empty.components.PortfolioCardId.LINK_ICON
import org.example.empty.components.PortfolioCardId.TITLE
import org.example.empty.models.Theme
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PortfolioSectionStyle by ComponentStyle {
    cssRule(" > #$COLUMN_PARENT > #$BOX_PARENT > #$GREEN_OVERLAY") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #$COLUMN_PARENT > #$BOX_PARENT > #$GREEN_OVERLAY") {
        Modifier.width(300.px)
    }

    cssRule(" > #$COLUMN_PARENT > #$BOX_PARENT > #$GREEN_OVERLAY > #$LINK_ICON") {
        Modifier.visibility(Visibility.Hidden)
    }

    cssRule(":hover > #$COLUMN_PARENT > #$BOX_PARENT > #$GREEN_OVERLAY > #$LINK_ICON") {
        Modifier.visibility(Visibility.Visible)
    }

    cssRule(" > #$COLUMN_PARENT > #$TITLE") {
        Modifier
            .color(Theme.Secondary.rgb)
            .translateX(0.percent)
            .transition(
                CSSTransition(property = "color", duration = 200.ms),
                CSSTransition(property = "translate", duration = 200.ms)
            )
    }

    cssRule(":hover > #$COLUMN_PARENT > #$TITLE") {
        Modifier
            .color(Theme.Primary.rgb)
            .translateX(5.percent)
    }

    cssRule(" > #$COLUMN_PARENT > #$DESCRIPTION") {
        Modifier
            .translateX(0.percent)
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #$COLUMN_PARENT > #$DESCRIPTION") {
        Modifier.translateX(5.percent)
    }
}
