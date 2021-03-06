/*
 * GitMessengerBot © 2021 지성빈 & 구환. all rights reserved.
 * GitMessengerBot license is under the GPL-3.0.
 *
 * [GithubRepoResult.kt] created by Ji Sungbin on 21. 7. 8. 오후 9:11.
 *
 * Please see: https://github.com/GitMessengerBot/GitMessengerBot-Android/blob/master/LICENSE.
 */

package me.sungbin.gitmessengerbot.activity.setup.github.repo

import me.sungbin.gitmessengerbot.activity.setup.github.model.GithubResultWrapper

sealed class GithubResult {
    data class Error(val exception: Exception) : GithubResult()
    data class Success(val result: GithubResultWrapper) : GithubResult()
}
