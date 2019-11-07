package com.contraslash.android.financial_planner.applications.core.layouts

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import com.contraslash.android.financial_planner.applications.core.activities.FinancialPlanner
import com.contraslash.android.financial_planner.applications.core.models.SMS

@Composable
fun SMSScreen(openDrawer: () -> Unit) {
    FinancialPlanner.Actions.smsController.checkPermissions()
    FinancialPlanner.Actions.smsController.loadMessages()
    VerticalScroller {

        Column {
            FinancialPlanner.Actions.smsController.allSMS.forEach {
                Row {
                    SMSElement(it)
                    WidthSpacer(width = 8.dp)
                }
            }            
        }
        
    }
}

@Composable
fun SMSElement(sms: SMS) {
    Column {
        Text(text = sms.body)
    }
}