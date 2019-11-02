package com.contraslash.android.financial_planner.applications.core.layouts

import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.compose.Composable

import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Spacing
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.contraslash.android.financial_planner.R
import com.contraslash.android.financial_planner.config.darkThemeColors


@Preview
@Composable
fun MainFinancialPlannerLayout() {
    MaterialTheme (
        colors = darkThemeColors
    )
    {
        Column (
            crossAxisSize = LayoutSize.Expand,
            crossAxisAlignment = CrossAxisAlignment.Center,
            modifier = Spacing(16.dp)
        ) {
            Button (
                text = Resources.getSystem().getString(R.string.app_name)
            )

        }
    }

}