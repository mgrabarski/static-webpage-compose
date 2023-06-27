package org.example.empty.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.launch
import org.example.empty.components.AchievementCard
import org.example.empty.models.Achievement
import org.example.empty.models.Section
import org.example.empty.models.Theme
import org.example.empty.util.AnimateNumbers
import org.example.empty.util.Constants.SECTION_WIDTH
import org.example.empty.util.ObserveViewportEntered
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    Box(
        modifier = Modifier
            .id(Section.Achievements.id)
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
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedNumbers = remember { mutableStateListOf(0, 0, 0, 0) }

    ObserveViewportEntered(
        sectionId = Section.Achievements.id,
        distanceFromTop = 700.0,
        onViewPortEntered = {
            viewportEntered = true
            enumValues<Achievement>().forEach { achievement ->
                scope.launch {
                    AnimateNumbers(
                        number = achievement.number,
                        onUpdate = {
                            animatedNumbers[achievement.ordinal] = it
                        }
                    )
                }
            }
        }
    )
    SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 4)) {
        enumValues<Achievement>().forEach {
            AchievementCard(
                modifier = Modifier
                    .margin(all = 30.px),
                achievement = it,
                animatedNumber = if (viewportEntered) animatedNumbers[it.ordinal] else 0
            )
        }
    }
}
