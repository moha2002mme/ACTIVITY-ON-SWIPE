package com.example.myactivite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val avtivity1 = findViewById<ConstraintLayout>(R.id.main)
        var click = findViewById<Button>(R.id.click)
        val longText = findViewById<TextView>(R.id.longText)
        click.setOnClickListener {
            Toast.makeText(this, "Button click ", Toast.LENGTH_SHORT).show()
            longText.text = "Simple Click On Button "
        }

        click.setOnLongClickListener {
            Toast.makeText(this@MainActivity, "Button Long click", Toast.LENGTH_SHORT).show()
            longText.text = "Long Click On Button"
            true
        }

        avtivity1.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft(): Boolean {
                val i = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(i)
                return true;
            }
        })
    }
}

