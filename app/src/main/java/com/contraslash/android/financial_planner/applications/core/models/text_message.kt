package com.contraslash.android.financial_planner.applications.core.models

data class SMS(
    val body: String,
    val originatingAddress: String,
    val timestamp: Long
)