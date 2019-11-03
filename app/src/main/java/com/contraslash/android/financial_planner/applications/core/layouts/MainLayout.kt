package com.contraslash.android.financial_planner.applications.core.layouts

import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.compose.Composable

import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import com.contraslash.android.financial_planner.R
import com.contraslash.android.financial_planner.config.MainApplication
import com.contraslash.android.financial_planner.config.darkThemeColors


@Preview
@Composable
fun MainFinancialPlannerLayout() {
    MaterialTheme (
        colors = darkThemeColors
    )
    {
        FlexColumn (
            crossAxisSize = LayoutSize.Expand,
            crossAxisAlignment = CrossAxisAlignment.Center
        ) {
            inflexible {
                TopAppBar(
                    title = {
                        Text(text = MainApplication.applicationContext().getString(R.string.app_name))
                    }
                )
            }
            flexible(flex = 1f) {

                Button (
                    text = MainApplication.applicationContext().getString(R.string.open_messages)
                )


            }
        }


    }

}