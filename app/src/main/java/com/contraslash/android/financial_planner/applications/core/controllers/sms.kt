package com.contraslash.android.financial_planner.applications.core.controllers

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SMSController {
    val PERMISSION_READ_SMS = 5801
    lateinit var activity: Activity
    var hasPermission: Boolean = false
        private set

    constructor(context: Activity) {
        this.activity = context
    }

    fun checkPermissions () {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this.activity,
                Manifest.permission.READ_SMS)
            != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity,
                    Manifest.permission.READ_SMS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this.activity,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    PERMISSION_READ_SMS)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
    }


}