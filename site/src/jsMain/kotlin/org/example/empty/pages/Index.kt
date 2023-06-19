package org.example.empty.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.VerticalAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.example.empty.sections.AboutSection
import org.example.empty.sections.MainSection
import org.jetbrains.compose.web.dom.Text

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
    }
}
