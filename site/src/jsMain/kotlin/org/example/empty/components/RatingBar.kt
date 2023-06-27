package org.example.empty.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.example.empty.util.Res.Icon
import org.jetbrains.compose.web.css.px

@Composable
fun RatingBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        repeat(times = 5) {
            Image(
                modifier = Modifier
                    .size(size = 16.px)
                    .margin(right = if (it != 4) 2.px else 0.px),
                src = Icon.star,
                desc = "Star Icon"
            )
        }
    }
}