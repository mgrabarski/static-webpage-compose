package org.example.empty.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.example.empty.sections.AboutSection
import org.example.empty.sections.AchievementsSection
import org.example.empty.sections.MainSection
import org.example.empty.sections.PortfolioSection
import org.example.empty.sections.ServiceSection
import org.example.empty.sections.TestimonialSection

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        MainSection()
        AboutSection()
        ServiceSection()
        PortfolioSection()
        AchievementsSection()
        TestimonialSection()
    }
}
