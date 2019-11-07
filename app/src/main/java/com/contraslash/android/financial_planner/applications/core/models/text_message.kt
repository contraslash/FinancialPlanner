package com.contraslash.android.financial_planner.applications.core.models

import androidx.compose.Model

@Model
data class SMS(
    val body: String,
    val originatingAddress: String,
    val timestamp: Long
)