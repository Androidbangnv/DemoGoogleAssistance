package com.example.demogoogleasisstent.car

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template
import com.example.demogoogleasisstent.R

class DeeplinkLandingScreen(
    val screenMessage: String,
    carContext: CarContext
) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        return MessageTemplate.Builder(
            screenMessage
        )
            .setTitle(carContext.getString(R.string.app_name))
            .build()
    }
}