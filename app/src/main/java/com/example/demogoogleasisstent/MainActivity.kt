package com.example.demogoogleasisstent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleEvent(intent)
    }

    val CAR_PARK = "https://todo.linbd.com/car_park"
    val NAVIGATION = "https://todo.linbd.com/navigate"

    private fun handleEvent(intent: Intent?) {
        intent?.let {

            if (intent.data.toString() == CAR_PARK) {
                Toast.makeText(this, "Open Carpark", Toast.LENGTH_LONG).show()
            } else if (intent.data.toString().contains(NAVIGATION)) {
                Toast.makeText(this, "navigation to " + intent.data.toString(), Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleEvent(intent)
    }
}