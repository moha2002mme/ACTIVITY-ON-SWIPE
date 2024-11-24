package com.example.myactivite

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity5 : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main5)
    //Calendar
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val bn = findViewById<Button>(R.id.dateButton)
    val date = findViewById<TextView>(R.id.dateSelect)
    val activity5 = findViewById<ConstraintLayout>(R.id.activity5)
    bn.setOnClickListener {
        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, myear, monthOfYear, dayOfMonth ->
        date.setText(""+dayOfMonth+"/"+ monthOfYear +"/" +myear)
        }, year, month, day)
        dpd.show()
    }
activity5.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity5) {
    override fun onSwipeRight(): Boolean {
        val i = Intent(this@MainActivity5,MainActivity4::class.java )
        startActivity(i)
        return true;
    }
    override fun onSwipeLeft(): Boolean {
        val i = Intent(this@MainActivity5,MainActivity6::class.java )
        startActivity(i)
        return true;
    }
})}}
