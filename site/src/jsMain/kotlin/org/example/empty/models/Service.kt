package org.example.empty.models

import org.example.empty.util.LOREM_IPSUM_SHORT
import org.example.empty.util.Res

enum class Service(
    val icon: String,
    val imageDescription: String,
    val title: String,
    val description: String
) {

    Android(
        icon = Res.Icon.android,
        imageDescription = "Android Icon",
        title = "Android Development",
        description = LOREM_IPSUM_SHORT
    ),
    IOS(
        icon = Res.Icon.apple,
        imageDescription = "Apple Icon",
        title = "iOS Development",
        description = LOREM_IPSUM_SHORT
    ),
    Web(
        icon = Res.Icon.web,
        imageDescription = "Desktop Icon",
        title = "Web Development",
        description = LOREM_IPSUM_SHORT
    ),
    Design(
        icon = Res.Icon.design,
        imageDescription = "Pen Icon",
        title = "UX/UI Design",
        description = LOREM_IPSUM_SHORT
    ),
    Business(
        icon = Res.Icon.business,
        imageDescription = "Chart Icon",
        title = "Business Analysis",
        description = LOREM_IPSUM_SHORT
    ),
    SEO(
        icon = Res.Icon.seo,
        imageDescription = "Megaphone Icon",
        title = "SEO Marketing",
        description = LOREM_IPSUM_SHORT
    )
}