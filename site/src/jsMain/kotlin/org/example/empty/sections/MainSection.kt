package org.example.empty.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaTwitter
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.empty.empty.LogoStyle
import org.example.empty.empty.MainButtonStyle
import org.example.empty.empty.MainImageStyle
import org.example.empty.empty.NavigationItemStyle
import org.example.empty.empty.SocialLinkStyle
import org.example.empty.models.Section
import org.example.empty.models.Theme
import org.example.empty.util.Constants
import org.example.empty.util.Constants.FONT_FAMILY
import org.example.empty.util.Constants.SECTION_WIDTH
import org.example.empty.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection() {
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(size = SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent(breakpoint = breakpoint)
    }
}

@Composable
fun MainBackground() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover),
        src = Res.Image.background,
        desc = "Background Image"
    )
}

@Composable
fun MainContent(
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(breakpoint = breakpoint)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint = breakpoint)
                MainImage()
            }
        }
    }
}

@Composable
fun Header(
    breakpoint: Breakpoint
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(percent = if (breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint = breakpoint)
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

@Composable
fun LeftSide(
    breakpoint: Breakpoint
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier
                    .margin(right = 15.px),
                size = IconSize.XL
            )
        }
        Image(
            modifier = LogoStyle
                .toModifier(),
            src = Res.Image.logo,
            desc = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(color = Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationItemStyle
                    .toModifier()
                    .padding(right = 30.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(value = 18.px)
                    .fontWeight(value = FontWeight.Normal)
                    .textDecorationLine(textDecorationLine = TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}

@Composable
fun SocialBar() {
    Column(
        modifier = Modifier
            .margin(right = 25.px)
            .padding(topBottom = 25.px)
            .minWidth(size = 40.px)
            .borderRadius(r = 20.px)
            .backgroundColor(color = Colors.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialLinks()
    }
}

@Composable
private fun SocialLinks() {
    Link(
        path = "https://github.com/mgrabarski",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaGithub(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = ""
    ) {
        FaTwitter(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = ""
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = ""
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.LG
        )
    }
}

@Composable
fun MainText(
    breakpoint: Breakpoint
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD) {
            SocialBar()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier.margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = if (breakpoint >= Breakpoint.LG) 45.px else 20.px)
                    .fontWeight(value = FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Hello I'm")
            }

            P(
                attrs = Modifier.margin(top = 20.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = if (breakpoint >= Breakpoint.LG) 68.px else 40.px)
                    .fontWeight(value = FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Mateusz Grabarski")
            }

            P(
                attrs = Modifier.margin(top = 10.px, bottom = 5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 20.px)
                    .fontWeight(value = FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Android Developer")
            }

            P(
                attrs = Modifier.margin(bottom = 25.px)
                    .maxWidth(400.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(value = 15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(value = FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            }

            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(40.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(color = Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(
                    modifier = Modifier
                        .color(color = Colors.White)
                        .textDecorationLine(TextDecorationLine.None),
                    text = "Hire me",
                    path = Section.Contact.path
                )
            }
        }
    }
}

@Composable
fun MainImage() {
    Column(
        modifier = MainImageStyle.toModifier()
            .fillMaxSize(80.percent)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            src = Res.Image.main_image,
            desc = "Main Image"
        )
    }
}