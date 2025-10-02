package com.theappsmiths.designsystem.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
inline fun Modifier.debounceClickable(
    debounceInterval: Long = 500L,
    crossinline onClick: () -> Unit,
): Modifier = composed {
    var lastClickTime by remember { mutableStateOf(0L) }
    clickable {
        val currentTime = Clock.System.now().toEpochMilliseconds()
        if ((currentTime - lastClickTime) < debounceInterval) return@clickable
        lastClickTime = currentTime
        onClick()
    }
}

@Composable
fun <T> rememberThrottledClickHandler(
    onClick: (T) -> Unit,
    debounceMillis: Long = 500L,
): (T) -> Unit {
    val coroutineScope = rememberCoroutineScope()
    var isProcessingClick by remember { mutableStateOf(false) }

    return { arg: T ->
        if (!isProcessingClick) {
            isProcessingClick = true
            onClick(arg)
            coroutineScope.launch {
                delay(debounceMillis)
                isProcessingClick = false
            }
        }
    }
}
