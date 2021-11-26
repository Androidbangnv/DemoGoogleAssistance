package com.example.demogoogleasisstent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleEvent(intent)
    }

    val CAR_PARK = "https://todo.linbd.com/car_park"
    val NAVIGATION = "https://todo.linbd.com/bang"

    private fun handleEvent(intent: Intent?) {
        intent?.let {
            Log.d("bangnv", intent.data.toString())
            if (intent.data.toString() == CAR_PARK) {
                Toast.makeText(this, "Open Carpark", Toast.LENGTH_LONG).show()
            } else if (intent.data.toString().contains(NAVIGATION)) {

                val uri = Uri.parse(intent.data.toString())
                Log.d("bangnv", intent.data.toString())
                Toast.makeText(this, "navigation to " + uri.getQueryParameter("place"), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleEvent(intent)
    }
}