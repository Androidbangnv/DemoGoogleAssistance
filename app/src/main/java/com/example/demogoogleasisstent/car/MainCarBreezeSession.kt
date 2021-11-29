package com.example.demogoogleasisstent.car

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.Session
import com.example.demogoogleasisstent.VoiceAssistanceUtils

class MainCarBreezeSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        handleDeeplinks(intent)
        return DeeplinkLandingScreen("This is a message from onCreate", carContext)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleDeeplinks(intent)
    }

    private fun handleDeeplinks(intent: Intent) {
        var screenManager: ScreenManager = carContext.getCarService(ScreenManager::class.java)
        screenManager.popToRoot()
        
        var message = "This is message from Deeplink"

        intent?.let {
            Log.d("bangnv", intent.data.toString())
            if (intent.data.toString() == VoiceAssistanceUtils.CAR_PARK) {
                message = "Open Carpark"
            } else if (intent.data.toString().contains(VoiceAssistanceUtils.NAVIGATION)) {

                val uri = Uri.parse(intent.data.toString())
                Log.d("bangnv", intent.data.toString())
                message = "navigation to ${uri.getQueryParameter("place")}"
            }
        }

        screenManager.push(DeeplinkLandingScreen(message, carContext))
    }
}
