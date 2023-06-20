package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.example.empty.models.Service
import org.example.empty.models.Theme
import org.example.empty.util.Constants
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(
    service: Service
) {
    Column(
        modifier = Modifier
            .maxWidth(size = 300.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LighterGray.rgb
            )
    ) {
        Box(
            modifier = Modifier
                .padding(all = 10.px)
                .margin(bottom = 20.px)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .borderRadius(
                    topLeft = 20.px,
                    topRight = 20.px,
                    bottomLeft = 20.px,
                    bottomRight = 0.px
                )
        ) {
            Image(
                modifier = Modifier
                    .size(size = 40.px),
                src = service.icon,
                desc = service.imageDescription
            )
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 25.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(value = 18.px)
                .fontWeight(value = FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(service.title)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(value = 14.px)
                .fontWeight(value = FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(service.description)
        }
    }
}