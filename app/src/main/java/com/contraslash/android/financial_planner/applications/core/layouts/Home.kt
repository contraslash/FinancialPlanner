package com.contraslash.android.financial_planner.applications.core.layouts

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.LayoutSize
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.contraslash.android.financial_planner.R
import com.contraslash.android.financial_planner.config.*

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
    FlexColumn (
        crossAxisSize = LayoutSize.Expand,
        crossAxisAlignment = CrossAxisAlignment.Center
    )
    {
        inflexible {
            TopAppBar(
                title = {
                    Text(text = MainApplication.applicationContext().getString(R.string.app_name))
                }
            )
        }
        flexible(flex = 1f) {
            Center {
                Button (
                    text = MainApplication.applicationContext().getString(R.string.open_messages),
                    onClick = { navigateTo(Screen.SMS) }
                )
            }
        }
    }
}