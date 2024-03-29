package com.contraslash.android.financial_planner.applications.core.controllers

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.contraslash.android.financial_planner.R
import com.contraslash.android.financial_planner.applications.core.models.SMS
import com.contraslash.android.financial_planner.config.AppConstants
import kotlinx.coroutines.channels.ActorScope

class SMSController(var activity: Activity) {
    val PERMISSIONCODE_READ_SMS = 5801
    val TAG = "SMSController"
    var hasPermission: Boolean = false
        private set
    var allSMS = mutableListOf<SMS>()
        private set

    fun checkPermissions () {
        Log.d(TAG, "Permission granted constant ${PackageManager.PERMISSION_GRANTED}")
        Log.d(TAG, "Permission granted constant ${ContextCompat.checkSelfPermission(
            this.activity,
            Manifest.permission.READ_SMS
        )}")
        if (ContextCompat.checkSelfPermission(
                this.activity,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED
        )
        {
            Log.d(TAG, "Permission not granted")
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this.activity,
                    Manifest.permission.READ_SMS)
            )
            {
                Log.d(TAG, "Showing permission rationale ")
                Toast.makeText(
                    this.activity,
                    this.activity.getString(R.string.sms_required),
                    Toast.LENGTH_LONG
                ).show()
            } else {

                Log.d(TAG, "Showing NOT so regular permission ")
                ActivityCompat.requestPermissions(
                    this.activity,
                    arrayOf(Manifest.permission.READ_SMS),
                    PERMISSIONCODE_READ_SMS
                )
            }
        } else {
            Log.d(TAG, "Permission granted?")
            this.hasPermission = true
        }
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    )
    {
        when (requestCode) {
            PERMISSIONCODE_READ_SMS -> {
                // If request is cancelled, the result arrays are empty.
                this.hasPermission = (grantResults.isNotEmpty()
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                )
                if (this.hasPermission) loadMessages()
                return
            }
            else -> {
                return
            }
        }
    }

    fun loadMessages() {
        if (!this.hasPermission) return
        ArrayList<SMS>()
        val contentResolver = this.activity.getContentResolver()
        val cursor = contentResolver.query(
            Uri.parse("content://sms/"),
            null,
            "",
            null,
            null
        )

        if (cursor!!.moveToFirst())
        {
            val addressID = cursor.getColumnIndex("address")
            val messageID = cursor.getColumnIndex("body")
            val dateID = cursor.getColumnIndex("date")
            do {
                // TODO: Remove fixed value from sender BANCOLOMBIA
                val senderAddress = cursor.getString(addressID)
                if (senderAddress == AppConstants.BANCOLOMBIA_SENDER_ADDRESS)
                    allSMS.add(
                        SMS(
                            cursor.getString(messageID),
                            senderAddress,
                            cursor.getLong(dateID)
                        )
                    )
            } while (cursor.moveToNext())
            Log.d(TAG, "Total elements ${allSMS.size}")

        }

    }

}