package com.example.myactivite

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity6 : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main6)
    val btnShowContextMenu = findViewById<Button>(R.id.btnShowContextMenu)
    val activity6 = findViewById<ConstraintLayout>(R.id.activity6)
    registerForContextMenu(btnShowContextMenu)
    btnShowContextMenu.setOnClickListener {
        openContextMenu(it)
    }
    activity6.setOnTouchListener(object : OnSwipeTouchListener(this@MainActivity6) {
        override fun onSwipeRight(): Boolean {
            val i = Intent(this@MainActivity6,MainActivity5::class.java )
            startActivity(i)
            return true;
        }
    })
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: 	ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_main, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.iItem1 -> {
                showToast("Select item 1")
                return true
            }
            R.id.iItem2 -> {
                showToast("Selected item 2")
                return true
            }
            R.id.iItem3 -> {
                showToast("Selected item 3")
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
