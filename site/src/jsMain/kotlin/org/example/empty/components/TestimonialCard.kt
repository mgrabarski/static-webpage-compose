package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.example.empty.models.Testimonial
import org.example.empty.models.Theme
import org.example.empty.util.Constants.FONT_FAMILY
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(
    modifier: Modifier = Modifier,
    testimonial: Testimonial,
    breakpoint: Breakpoint
) {
    Row(
        modifier = modifier
            .maxWidth(size = 450.px)
    ) {
        Image(
            modifier = Modifier
                .margin(right = 20.px)
                .maxWidth(size = if (breakpoint >= Breakpoint.MD) 160.px else 80.px)
                .borderRadius(
                    topLeft = 60.px,
                    topRight = 60.px,
                    bottomLeft = 60.px,
                    bottomRight = 0.px
                ),
            src = testimonial.image,
            desc = "Avatar Image"
        )
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 10.px)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
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
                        Text(value = testimonial.fullName)
                    }
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(value = 12.px)
                            .fontWeight(value = FontWeight.Normal)
                            .color(color = Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(testimonial.profession)
                    }
                }
                RatingBar(modifier = Modifier.margin(top = 5.px))
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 12.px)
                    .fontWeight(value = FontWeight.Normal)
                    .color(color = Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(testimonial.review)
            }
        }
    }
}