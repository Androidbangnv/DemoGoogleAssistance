package com.example.demogoogleasisstent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleEvent()
    }

    val CAR_PARK = "https://todo.linbd.com/car_park"

    private fun handleEvent() {
        intent?.let {

            if (intent.data.toString() == CAR_PARK) {
                Toast.makeText(this, "Open Carpark", Toast.LENGTH_LONG).show()
            }

//            else if () {
//            }


        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }
}