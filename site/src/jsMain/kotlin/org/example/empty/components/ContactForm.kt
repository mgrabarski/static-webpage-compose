package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.example.empty.models.Theme
import org.example.empty.style.InputStyle
import org.example.empty.style.MainButtonStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun ContactForm(
    breakpoint: Breakpoint
) {
    Form(
        action = "https://formspree.io/f/myyqyzkv",
        attrs = Modifier
            .attrsModifier {
                attr(attr = "method", value = "POST")
            }
            .toAttrs()
    ) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputName"
        ) {
            Text(value = "Name")
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id(value = "inputName")
                .margin(bottom = 10.px)
                .boxShadow(
                    offsetX = 0.px,
                    offsetY = 0.px,
                    blurRadius = 0.px,
                    spreadRadius = 0.px,
                    color = null
                )
                .classNames("form-control")
                .width(size = if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .backgroundColor(color = Theme.LighterGray.rgb)
                .attrsModifier {
                    attr(attr = "placeholder", value = "Full name")
                    attr(attr = "required", value = "true")
                    attr(attr = "name", value = "name")
                }
                .toAttrs()
        )
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputEmail"
        ) {
            Text(value = "Email")
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id(value = "inputEmail")
                .margin(bottom = 10.px)
                .boxShadow(
                    offsetX = 0.px,
                    offsetY = 0.px,
                    blurRadius = 0.px,
                    spreadRadius = 0.px,
                    color = null
                )
                .classNames("form-control")
                .width(size = if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .backgroundColor(color = Theme.LighterGray.rgb)
                .attrsModifier {
                    attr(attr = "placeholder", value = "Email Address")
                    attr(attr = "required", value = "true")
                    attr(attr = "name", value = "email")
                }
                .toAttrs()
        )

        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputMessage"
        ) {
            Text(value = "Message")
        }
        TextArea(
            attrs = InputStyle.toModifier()
                .id(value = "inputMessage")
                .margin(bottom = 20.px)
                .height(size = 150.px)
                .boxShadow(
                    offsetX = 0.px,
                    offsetY = 0.px,
                    blurRadius = 0.px,
                    spreadRadius = 0.px,
                    color = null
                )
                .classNames("form-control")
                .width(size = if (breakpoint >= Breakpoint.MD) 500.px else 250.px)
                .backgroundColor(color = Theme.LighterGray.rgb)
                .attrsModifier {
                    attr(attr = "placeholder", value = "Your Message")
                    attr(attr = "required", value = "true")
                    attr(attr = "name", value = "message")
                }
                .toAttrs()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(size = 40.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(color = Theme.Primary.rgb)
                    .color(color = Colors.White)
                    .cursor(cursor = Cursor.Pointer)
                    .toAttrs()
            ) {
                Text(value = "Submit")
            }
        }
    }
}

object ContactFormInputsId {

}