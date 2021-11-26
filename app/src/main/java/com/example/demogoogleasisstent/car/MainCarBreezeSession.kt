package com.example.demogoogleasisstent.car

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.Session

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
        //val screenOntop = screenManager.top
        screenManager.push(DeeplinkLandingScreen("This is message from Deeplink", carContext))
//        if(screenOntop != null) {
//            screenManager.remove(screenOntop)
//        }
    }
}
