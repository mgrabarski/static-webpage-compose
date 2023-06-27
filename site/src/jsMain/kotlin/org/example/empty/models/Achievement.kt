package org.example.empty.models

import org.example.empty.util.Res.Icon

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Icon.checkmark,
        number = 120,
        description = "Completed Projects"
    ),
    Active(
        icon = Icon.shield,
        number = 12,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Icon.happy,
        number = 42,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Icon.user,
        number = 10,
        description = "Team Members"
    )
}