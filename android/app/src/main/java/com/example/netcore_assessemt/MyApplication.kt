package com.example.netcore_assessment  // Replace with your actual package name

import android.app.Application
import android.util.Log
import com.netcore.smartech.Smartech
import com.netcore.smartech.SmartechBasePlugin
import java.lang.ref.WeakReference

class MyApplication : FlutterApplication() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Smartech SDK
        Smartech.getInstance(WeakReference(applicationContext)).initializeSdk(this)
        // Enable debugging logs
        Smartech.getInstance(WeakReference(applicationContext)).setDebugLevel(9)
        // Track app install and updates
        Smartech.getInstance(WeakReference(applicationContext)).trackAppInstallUpdateBySmartech()

        // Initialize Flutter Smartech Base Plugin
        SmartechBasePlugin.initializePlugin(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d("onTerminate", "onTerminate")
    }
}
