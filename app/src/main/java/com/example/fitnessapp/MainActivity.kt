package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Code for full screen mode, hiding navigation bar and changing behaviour with swipe
        //ref- https://developer.android.com/develop/ui/views/layout/immersive#java
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.drawer_menu_item_1 -> startActivity(Intent(this@MainActivity, Workouts::class.java))
            R.id.drawer_menu_item_2 -> startActivity(Intent(this@MainActivity, Programs::class.java))
            R.id.drawer_menu_item_3 -> startActivity(Intent(this@MainActivity, Challenges::class.java))
            R.id.drawer_menu_item_4 -> startActivity(Intent(this@MainActivity, Guides::class.java))
            R.id.drawer_menu_item_5 -> startActivity(Intent(this@MainActivity, Collections::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }

}