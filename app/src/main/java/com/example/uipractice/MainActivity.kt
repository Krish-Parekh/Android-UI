package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.uipractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    /*
    * lateinit var means we will initialize this toggle later on || We can initialize it to null
    *
    * ActionBarDrawerToggle : This class provides a handy way to tie together the functionality of DrawerLayout and the framework ActionBar to implement the recommended design for navigation drawers.
    * */

    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ActionBarDrawerToggle(activity we want that on , our drawer layout , this strings are for blind people if they open or close it to read out loud)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)

        // Listener for monitoring events about drawers. -> like open ,close ,slide change
        binding.drawerLayout.addDrawerListener(toggle)

        // its like we tell toggle its ready to be used , Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout.
        toggle.syncState()

        // We are able to open our toggle and that toggle button moves to back arrow
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.miItem1 -> Toast.makeText(
                    applicationContext,
                    "item1 Clicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.miItem2 -> Toast.makeText(
                    applicationContext,
                    "item2 Clicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.miItem3 -> Toast.makeText(
                    applicationContext,
                    "item3 Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }
            // returning true means we handled out click
            true
        }
    }

    // This is to respond click on our toggle button and to respond to menu item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}