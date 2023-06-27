package org.example.empty.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewPortEntered: () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewPortEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        } else {
            window.addEventListener("scroll", callback = listener)
        }
    }
}

suspend fun AnimateNumbers(
    number: Int,
    delay: Long = 10L,
    onUpdate: (Int) -> Unit
) {
    repeat((0..number).count()) {
        delay(delay)
        onUpdate(it)
    }
}