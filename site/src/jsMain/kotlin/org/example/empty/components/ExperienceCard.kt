package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.example.empty.models.Experience
import org.example.empty.models.Theme
import org.example.empty.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    active: Boolean = false,
    experience: Experience,
    breakpoint: Breakpoint,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                size = if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent
            ),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        ExperienceDescription(
            active = active,
            description = experience.description
        )
        ExperienceDetails(
            breakpoint = breakpoint,
            active = active,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
private fun ExperienceDescription(
    active: Boolean,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 14.px)
            .padding(all = 14.px)
            .backgroundColor(color = if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(value = 14.px)
                .lineHeight(value = 1.6)
                .fontWeight(value = FontWeight.Normal)
                .color(color = if (active) Colors.White else Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(value = description)
        }
    }
}

@Composable
private fun ExperienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceNumber(
                active = active,
                experience = experience
            )
        }
        ExperienceDetails(
            breakpoint = breakpoint,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
private fun ExperienceNumber(
    active: Boolean,
    experience: Experience
) {
    Box(
        modifier = Modifier
            .margin(leftRight = 35.px)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(size = 3.px)
                .backgroundColor(color = Theme.Primary.rgb)
        )
        Box(
            modifier = Modifier
                .size(size = 40.px)
                .borderRadius(r = 50.percent)
                .backgroundColor(if (active) Theme.Primary.rgb else Colors.White)
                .border(
                    width = 3.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                ),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 16.px)
                    .fontWeight(value = FontWeight.Bold)
                    .color(color = if (active) Colors.White else Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(value = experience.number)
            }
        }
    }
}

@Composable
private fun ExperienceDetails(
    breakpoint: Breakpoint,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(size = 200.px)
            .margin(left = if (breakpoint <= Breakpoint.SM) 0.px else animatedMargin)
            .transition(
                CSSTransition("margin", delay = experience.ordinal * 25.ms, duration = 600.ms)
            ),
        verticalArrangement = Arrangement.Center
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(value = 20.px)
                .fontWeight(value = FontWeight.Bold)
                .color(color = Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(value = experience.jobPosition)
        }
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(value = 14.px)
                .fontWeight(value = FontWeight.Normal)
                .color(color = Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(value = "${experience.from} - ${experience.to}")
        }
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(value = 14.px)
                .fontWeight(value = FontWeight.Normal)
                .color(color = Theme.Primary.rgb)
                .toAttrs()
        ) {
            Text(value = experience.company)
        }
    }
}