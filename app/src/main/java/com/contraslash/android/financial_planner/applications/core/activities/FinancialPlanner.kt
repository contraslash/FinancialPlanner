package com.contraslash.android.financial_planner.applications.core.activities

import android.app.Activity
import android.os.Bundle
import androidx.ui.core.setContent
import com.contraslash.android.financial_planner.applications.core.controllers.SMSController

import com.contraslash.android.financial_planner.applications.core.layouts.MainFinancialPlannerLayout

class FinancialPlanner : Activity() {

    lateinit var smsController: SMSController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainFinancialPlannerLayout()
        }

        this.smsController = SMSController(this)
        this.smsController.checkPermissions()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        this.smsController.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
