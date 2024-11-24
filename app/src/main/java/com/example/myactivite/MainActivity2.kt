package com.example.myactivite

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myactivite.databinding.ActivityMain2Binding
import com.example.myactivite.databinding.ActivityMain2Binding.inflate

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val myInput = findViewById<EditText>(R.id.input)
        val textView = findViewById<TextView>(R.id.text)
        val avtivity2 = findViewById<ConstraintLayout>(R.id.activity2)

        myInput.addTextChangedListener(object :TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textView.setText("Text : " + p0)
        }
        override fun afterTextChanged(p0: Editable?) {
        //
        }
        })
        myInput.setOnFocusChangeListener(object :OnFocusChangeListener{
            override fun onFocusChange(p0: View?, p1: Boolean) {
                if(p1) {
                    Toast.makeText(this@MainActivity2, "Edit Text As Focus",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@MainActivity2, "EditText Lost Focus", Toast.LENGTH_SHORT).show()
                }
            }
        })
        myInput.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(this@MainActivity2,"Key Enter",Toast.LENGTH_SHORT).show()
                return@OnKeyListener true
            }
            false
        })
        avtivity2.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity2) {
            override fun onSwipeRight(): Boolean {
                val i = Intent(this@MainActivity2,MainActivity::class.java )
                startActivity(i)
                return true;
            }
            override fun onSwipeLeft(): Boolean {
                val i = Intent(this@MainActivity2,MainActivity3::class.java )
                startActivity(i)
                return true;
            }
        })
    }
}


