package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.uipractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        * Return the FragmentManager for interacting with fragments associated with this activity.
        * */
        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        /*
        * NavController manages app navigation within a NavHost.
        * Apps will generally obtain a controller directly from a host, or by using one of the utility methods on
        * the Navigation class rather than create a controller directly.
        *
        * Navigation flows and destinations are determined by the navigation graph owned by the controller.
        * These graphs are typically inflated from an Android resource, but, like views, they can also be constructed
        * or combined programmatically or for the case of dynamic navigation structure.
        * */

        val navController = navHostFragment.navController
        /*
        * Sets up the ActionBar returned by AppCompatActivity.getSupportActionBar for use with a NavController.
        * By calling this method, the title in the action bar will automatically be updated when the destination
        * changes (assuming there is a valid label).
        * */
        setupActionBarWithNavController(navController)
    }
    /*
    * onSupportNavigateUp :
    * Handles the Up button by delegating its behavior to the given NavController. This should generally be called from
    * */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}