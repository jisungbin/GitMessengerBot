/*
 * GitMessengerBot © 2021 지성빈 & 구환. all rights reserved.
 * GitMessengerBot license is under the GPL-3.0.
 *
 * Please see: https://github.com/GitMessengerBot/GitMessengerBot-Android/blob/master/LICENSE.
 */

package me.sungbin.gitmessengerbot.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.sungbin.gitmessengerbot.R
import me.sungbin.gitmessengerbot.theme.BindView
import me.sungbin.gitmessengerbot.theme.SystemUiController
import me.sungbin.gitmessengerbot.theme.colors
import me.sungbin.gitmessengerbot.theme.defaultFontFamily
import me.sungbin.gitmessengerbot.theme.twiceLightGray
import me.sungbin.gitmessengerbot.ui.fancybottombar.FancyBottomBar
import me.sungbin.gitmessengerbot.ui.fancybottombar.FancyColors
import me.sungbin.gitmessengerbot.ui.fancybottombar.FancyItem
import me.sungbin.gitmessengerbot.ui.fancybottombar.FancyOptions

/**
 * Created by Ji Sungbin on 2021/04/15.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SystemUiController(window).run {
            setStatusBarColor(colors.primary)
            setNavigationBarColor(Color.White)
        }

        val items = listOf(
            FancyItem("Folders", R.drawable.ic_baseline_folder_24, 0),
            FancyItem(icon = R.drawable.ic_baseline_error_24, id = 1),
            FancyItem(title = "Keys", icon = R.drawable.ic_baseline_key_24, id = 2),
            FancyItem("More?", id = 3)
        )

        setContent {
            val fancyNavigationState = rememberSaveable { mutableStateOf(0) }

            BindView {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colors.primary)
                ) {
                    Crossfade(
                        targetState = fancyNavigationState.value,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 60.dp)
                    ) { index ->
                        // BindFancyPage(index = index)
                    }
                    MainViewBind()
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            FancyBottomBar(
                                fancyColors = FancyColors(primary = colors.primary),
                                fancyOptions = FancyOptions(fontFamily = defaultFontFamily),
                                items = items
                            ) { fancyNavigationState.value = id }
                            Box(
                                modifier = Modifier.padding(bottom = 30.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Circle,
                                    contentDescription = null,
                                    tint = colors.primary,
                                    modifier = Modifier.size(60.dp)
                                )
                                Icon(
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MainViewBind() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.End
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "GitMessengerBot", color = Color.LightGray, fontSize = 13.sp)
                    Text(
                        text = "Hi, jisungbin",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                StateItemBind(title = "메인 전원", modifier = Modifier.weight(1f)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("On")
                        Switch(
                            checked = false,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = colors.primary,
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = colors.secondary
                            ),
                            onCheckedChange = {}
                        )
                    }
                }
                StateItemBind(title = "총 스크립트 수", modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "2", fontSize = 35.sp)
                        Text(text = "개", fontSize = 8.sp)
                    }
                }
                StateItemBind(title = "실행중인\n스크립트 수", modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "2", fontSize = 35.sp)
                        Text(text = "개", fontSize = 8.sp)
                    }
                }
                StateItemBind(title = "스크립트 검색", modifier = Modifier.weight(1f)) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = null,
                            modifier = Modifier.size(45.dp),
                            tint = Color.Black
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 50f, topEnd = 50f))
                .background(twiceLightGray)
        ) {
        }
    }
}

@Composable
private fun StateItemBind(title: String, modifier: Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .width(75.dp)
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            content()
        }
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}
