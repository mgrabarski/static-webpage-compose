package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import org.example.empty.models.Portfolio
import org.example.empty.models.Theme
import org.example.empty.util.Constants.FONT_FAMILY
import org.example.empty.util.Constants.WEBSITE
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
    link: String = WEBSITE
) {
    Link(
        modifier = Modifier
            .textDecorationLine(TextDecorationLine.None),
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = modifier
                .width(width = Width.MaxContext)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .maxWidth(size = 300.px)
                    .margin(
                        bottom = 20.px
                    )
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 300.px)
                        .objectFit(objectFit = ObjectFit.Cover),
                    src = portfolio.image,
                    desc = "Portfolio image"
                )
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 18.px)
                    .fontWeight(value = FontWeight.Bold)
                    .color(color = Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 14.px)
                    .fontWeight(value = FontWeight.Normal)
                    .opacity(value = 50.percent)
                    .color(color = Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(portfolio.description)
            }
        }
    }
}