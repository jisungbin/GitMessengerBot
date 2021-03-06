/*
 * GitMessengerBot © 2021 지성빈 & 구환. all rights reserved.
 * GitMessengerBot license is under the GPL-3.0.
 *
 * [Modifier.kt] created by Ji Sungbin on 21. 7. 9. 오후 10:53.
 *
 * Please see: https://github.com/GitMessengerBot/GitMessengerBot-Android/blob/master/LICENSE.
 */

@file:Suppress("UnnecessaryComposedModifier")

package me.sungbin.gitmessengerbot.util.extension

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

// https://stackoverflow.com/a/66839858/14299073
inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

@OptIn(ExperimentalFoundationApi::class)
inline fun Modifier.noRippleLongClickable(crossinline onLongClick: () -> Unit) = composed {
    combinedClickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = {},
        onLongClick = { onLongClick() }
    )
}
