package com.contraslash.android.financial_planner.applications.core.layouts

import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade

import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import com.contraslash.android.financial_planner.R
import com.contraslash.android.financial_planner.config.*


@Preview
@Composable
fun MainFinancialPlannerLayout() {
    MaterialTheme (
        colors = customThemeColors
    )
    {
        val (drawerState, onDrawerStateChange) = +state { DrawerState.Closed }

        ModalDrawerLayout(
            drawerState = drawerState,
            onStateChange = onDrawerStateChange,
            drawerContent = {
                AppDrawer(
                    currentScreen = MainStore.currentScreen,
                    closeDrawer = { onDrawerStateChange(DrawerState.Closed) }
                )
            },
            bodyContent = { AppContent { onDrawerStateChange(DrawerState.Opened) } }
        )
    }
}

@Composable
private fun AppContent(openDrawer: () -> Unit) {
    Crossfade(MainStore.currentScreen) { screen ->
        Surface(color = +themeColor { background }) {
            when (screen) {
                is Screen.Home -> HomeScreen { openDrawer() }
                is Screen.SMS -> SMSScreen{ openDrawer() }

            }
        }
    }
}

@Composable
private fun AppDrawer(
    currentScreen: Screen,
    closeDrawer: () -> Unit
) {
    Column(
        crossAxisSize = LayoutSize.Expand,
        mainAxisSize = LayoutSize.Expand
    ) {
        HeightSpacer(24.dp)
        Padding(16.dp) {
            Row {
                Text(text = MainApplication.applicationContext().getString(R.string.app_name))
            }
        }
        Divider(color = Color(0x14333333))
        DrawerButton(
            label = MainApplication.applicationContext().getString(R.string.main_title),
            isSelected = currentScreen == Screen.Home
        ) {
            navigateTo(Screen.Home)
            closeDrawer()
        }
        DrawerButton(
            label = MainApplication.applicationContext().getString(R.string.sms_title),
            isSelected = currentScreen == Screen.SMS
        ) {
            navigateTo(Screen.SMS)
            closeDrawer()
        }
    }
}


@Composable
private fun DrawerButton(
    label: String,
    isSelected: Boolean,
    action: () -> Unit
) {
    val textIconColor = if (isSelected) {
        +themeColor { primary }
    } else {
        (+themeColor { onSurface }).copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        (+themeColor { primary }).copy(alpha = 0.12f)
    } else {
        +themeColor { surface }
    }

    Padding(left = 8.dp, top = 8.dp, right = 8.dp) {
        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(4.dp)
        ) {
            Button(onClick = action, style = TextButtonStyle()) {
                Row(
                    mainAxisSize = LayoutSize.Expand,
                    crossAxisAlignment = CrossAxisAlignment.Center
                ) {
                    WidthSpacer(16.dp)
                    Text(
                        text = label,
                        style = (+themeTextStyle { body2 }).copy(
                            color = textIconColor
                        )
                    )
                }
            }
        }
    }
}
