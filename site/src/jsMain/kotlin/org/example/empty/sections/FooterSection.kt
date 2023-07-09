package org.example.empty.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.empty.models.Section
import org.example.empty.models.Theme
import org.example.empty.style.NavigationItemStyle
import org.example.empty.util.Constants
import org.example.empty.util.Constants.FONT_FAMILY
import org.example.empty.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(size = Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(color = Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        FooterSectionContent()
    }
}

@Composable
private fun FooterSectionContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) {
                    100.percent
                } else {
                    90.percent
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(size = 100.px),
            src = Res.Image.logo,
            desc = "Logo Image"
        )
        if (breakpoint > Breakpoint.SM) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                FooterMenu()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FooterMenu(row = false)
            }
        }
        SocialBar(
            row = true
        )
    }
}

@Composable
private fun FooterMenu(row: Boolean = true) {
    enumValues<Section>().forEach {
        Link(
            modifier = NavigationItemStyle
                .toModifier()
                .padding(
                    right = if (row) 20.px else 0.px,
                    bottom = if (row) 0.px else 20.px
                )
                .fontSize(value = 12.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(value = FontWeight.Normal)
                .textDecorationLine(textDecorationLine = TextDecorationLine.None),
            path = it.path,
            text = it.title
        )
    }
}