package org.example.empty.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.example.empty.components.AchievementCard
import org.example.empty.models.Achievement
import org.example.empty.models.Section
import org.example.empty.models.Theme
import org.example.empty.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    Box(
        modifier = Modifier
            .id(Section.Portfolio.id)
            .fillMaxWidth()
            .maxWidth(size = SECTION_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(color = Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        AchievementsSectionContent()
    }
}

@Composable
private fun AchievementsSectionContent() {
    SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 4)) {
        enumValues<Achievement>().forEach {
            AchievementCard(
                modifier = Modifier
                    .margin(all = 30.px),
                achievement = it)
        }
    }
}
