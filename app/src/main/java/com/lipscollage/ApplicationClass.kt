package com.lipscollage

import android.app.Application
import com.onesignal.OneSignal


class ApplicationClass : Application() {
    private val ONESIGNAL_APP_ID = "73d6b66f-4c86-40e8-8075-07c20d0743b5"

    override fun onCreate() {
        super.onCreate()
        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}