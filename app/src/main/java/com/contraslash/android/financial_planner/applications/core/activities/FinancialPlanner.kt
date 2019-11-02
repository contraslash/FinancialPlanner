package com.contraslash.android.financial_planner.applications.core.activities

import android.app.Activity
import android.os.Bundle
import androidx.ui.core.setContent

import com.contraslash.android.financial_planner.applications.core.layouts.MainFinancialPlannerLayout

class FinancialPlanner : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainFinancialPlannerLayout()
        }
    }
}
