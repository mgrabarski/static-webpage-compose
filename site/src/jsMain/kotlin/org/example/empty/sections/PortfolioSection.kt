package org.example.empty.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.example.empty.components.PortfolioCard
import org.example.empty.components.SectionTitle
import org.example.empty.models.Portfolio
import org.example.empty.models.Section
import org.example.empty.sections.PortfolioSectionIds.SCROLLABLE_CONTAINER
import org.example.empty.style.PortfolioArrowIconStyle
import org.example.empty.util.Constants
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(size = Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
private fun PortfolioContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(
                percent = if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px),
            section = Section.Portfolio
        )
        PortfolioCards(
            breakpoint = breakpoint
        )
        PortfolioNavigation()
    }
}

@Composable
private fun PortfolioCards(breakpoint: Breakpoint) {
    Row(
        modifier = Modifier
            .id(value = SCROLLABLE_CONTAINER)
            .fillMaxWidth()
            .margin(bottom = 25.px)
            .maxWidth(
                size = if (breakpoint > Breakpoint.MD) 950.px
                else if (breakpoint > Breakpoint.SM) 625.px
                else 300.px
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
    ) {
        Portfolio.values().forEach { portfolio ->
            PortfolioCard(
                modifier = Modifier.margin(
                    right = if (portfolio != Portfolio.Five) 25.px else 0.px
                ),
                portfolio = portfolio
            )
        }
    }
}

private object PortfolioSectionIds {
    const val SCROLLABLE_CONTAINER = "scrollableContainer"
}

@Composable
private fun PortfolioNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        FaArrowLeft(
            modifier = PortfolioArrowIconStyle.toModifier()
                .margin(right = 40.px)
                .cursor(cursor = Cursor.Pointer)
                .onClick {
                    document.getElementById(SCROLLABLE_CONTAINER)
                        ?.scrollBy(
                            x = -325.0,
                            y = 0.0
                        )
                },
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = PortfolioArrowIconStyle.toModifier()
                .margin(right = 40.px)
                .cursor(cursor = Cursor.Pointer)
                .onClick {
                    document.getElementById(SCROLLABLE_CONTAINER)
                        ?.scrollBy(
                            x = 325.0,
                            y = 0.0
                        )
                },
            size = IconSize.LG
        )
    }
}