package org.example.empty.models

import org.example.empty.util.Res.Image

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Image.portfolio1,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Image.portfolio2,
        title = "Landing Page for NFT",
        description = "Frontend"
    ),
    Three(
        image = Image.portfolio3,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Image.portfolio4,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Image.portfolio5,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}