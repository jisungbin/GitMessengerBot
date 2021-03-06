/*
 * GitMessengerBot © 2021 지성빈 & 구환. all rights reserved.
 * GitMessengerBot license is under the GPL-3.0.
 *
 * [ApiClass.kt] created by Ji Sungbin on 21. 7. 10. 오전 11:30.
 *
 * Please see: https://github.com/GitMessengerBot/GitMessengerBot-Android/blob/master/LICENSE.
 */

package me.sungbin.gitmessengerbot.bot.rhino

import org.mozilla.javascript.ScriptableObject
import org.mozilla.javascript.annotations.JSStaticFunction

object ApiClass {
    class App : ScriptableObject() {
        override fun getClassName() = "Api"

        companion object {
            @JvmStatic
            @JSStaticFunction
            fun getContext() = "todo" // todo
        }
    }
}
